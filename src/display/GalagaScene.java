package display;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import gameComponents.BlueBadGuy;
import gameComponents.GreenBadGuy;
import gameComponents.Player;
import gameComponents.PlayerDevice;
import gameComponents.RedBadGuy;
import gameComponents.Shooter;
import gamePlay.Galaga;
import gamePlay.Game;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

//@author: Milli Kearse
//This class shows the scene for the Galaga game.
public class GalagaScene extends SetScene {

	public static final String TITLE = "Galaga";
	private Scene myScene;
	private Scene levelOneScene;
	private Scene levelTwoScene;
	private Scene levelThreeScene;

	public static final int width = 385;
	public static final int height = 500;
	public static final Paint BACKGROUND = Color.web("#feb4de"); //pink
	public static final Paint LEVEL_ONE_BACKGROUND = Color.web("#011a52"); //blue
	public static final Paint LEVEL_TWO_BACKGROUND = Color.web("#f5e790"); //yellow
	public static final Paint LEVEL_THREE_BACKGROUND = Color.web("#8ae384"); //green

	public static final int FRAMES_PER_SECOND = 60;
	public static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	public static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;

	public static final String GREEN_BAD_GUY_IMAGE = "resources/GreenBadGuy.gif";
	public static final String RED_BAD_GUY_IMAGE = "resources/RedBadGuy.gif";
	public static final String BLUE_BAD_GUY_IMAGE = "resources/BlueBadGuy.gif";
	public static final String 	MY_PLAYER = "resources/galaga_shooter.png";

	File file = new File("TOPSCORE");

	private List<GreenBadGuy> myGreenBadGuys;
	private List<RedBadGuy> myRedBadGuys;
	private List<BlueBadGuy> myBlueBadGuys;

	Galaga gamer = new Galaga();
	//Game gamer = new Game();

	GreenBadGuy green;
	RedBadGuy red;
	BlueBadGuy blue;
	PlayerDevice device;
	Player player;
	Shooter shooter;
	Timeline animation;

	Text displayScore = new Text();
	Text displayLives = new Text();
	Text lostMessage = new Text();
	Text winMessage = new Text();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start (Stage stage) {
		// attach scene to the stage and display it
		myScene = setUpGame(width, height, BACKGROUND);
		stage.setScene(myScene);
		stage.setTitle(TITLE);
		stage.show();
		// attach "game loop" to timeline to play it (basically just calling step() method repeatedly forever)
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> step(SECOND_DELAY, stage));;
		animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		//animation.getKeyFrames().add(frame);
		animation.play();
	}

	public Scene setUpGame (int width, int height, Paint background) {
		Group root = new Group();
		player = new Player();

		int BRICKXPOSITION = 0;
		int BRICKYPOSITION = 0;

		myGreenBadGuys = new ArrayList<>();  
		myRedBadGuys = new ArrayList<>();  
		myBlueBadGuys = new ArrayList<>();

		while (BRICKYPOSITION <= height/2.5) {
			while (BRICKXPOSITION <= width) {
				try {
					Image imageGreen = new Image(new FileInputStream(GREEN_BAD_GUY_IMAGE));
					green = new GreenBadGuy(imageGreen, BRICKXPOSITION, BRICKYPOSITION);

					Image imageRed = new Image(new FileInputStream(RED_BAD_GUY_IMAGE));
					red = new RedBadGuy(imageRed, BRICKXPOSITION, BRICKYPOSITION);

					Image imageBlue = new Image(new FileInputStream(BLUE_BAD_GUY_IMAGE));
					blue = new BlueBadGuy(imageBlue, BRICKXPOSITION, BRICKYPOSITION);
				}
				catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				myGreenBadGuys.add(green);
				myRedBadGuys.add(red);
				myBlueBadGuys.add(blue);
				root.getChildren().add(green.getView()); 
				root.getChildren().add(red.getView()); 
				root.getChildren().add(blue.getView()); 

				BRICKXPOSITION += green.getWidth() + 5;   
			}
			this.green.setPoints(green.getPoints() - 1);
			BRICKYPOSITION += green.getHeight() + 5; 
			BRICKXPOSITION = 0;
		}

		//calls the SetScene class to load all text display.
		super.createGroup();
		Scene scene = new Scene(root, width, height, background);
		//respond to input 
		scene.setOnKeyPressed(e -> gamer.handleKeyInput(e.getCode(), device));
		return scene;
	}

	private void step (double elapsedTime, Stage stage) {
		int count = 0;

		for (GreenBadGuy green : myGreenBadGuys) {
			for (RedBadGuy red: myRedBadGuys) {
				for (BlueBadGuy blue: myBlueBadGuys) {
					player.setScore(player.getScore());
					displayScore.setText("SCORE: " + String.valueOf(player.getScore()));
					System.out.println(player.getScore());

					//once all bad guys are cleared, go to level one
					if(player.getScore() == 477) {
						count += 1;
						levelOneScene = setUpGame(width, height, LEVEL_ONE_BACKGROUND);
						stage.setScene(levelOneScene);
					}

					//once all bad guys are cleared in level 1, go to level 2
					if(player.getScore() == 954) {
						count += 1;
						levelTwoScene = setUpGame(width, height, LEVEL_TWO_BACKGROUND);
						stage.setScene(levelTwoScene);
					}

					//once all bad guys are cleared in level 2, go to level 3
					if(player.getScore() == 1431) {
						count += 1;
						levelThreeScene = setUpGame(width, height, LEVEL_THREE_BACKGROUND);
						stage.setScene(levelThreeScene);
					}
				}
			}

		}

		//all levels cleared, gamer.hasWon
		if (gamer.hasWon(count)) {
			animation.stop();
			//reads in current score into scores file to check for high score
			addCurrentScoreToScoresFile(player.getScore(), file);
			//save a high score to the scores file
			int highScore=0;
			try {
				// Read the score file line by line
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String line = reader.readLine();
				while (line != null)                 
				{
					try {
						// Parse each line as an int
						int score = Integer.parseInt(line.trim()); 
						// Keep track of the largest score
						if (score > highScore)                       
						{ 
							highScore = score; 
						}
					} catch (NumberFormatException e) {
						e.printStackTrace();
					}
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException ex) {
				System.err.println("Couldn't read in scores from file");
			}
			// report a won message 
			super.createGroup().getChildren().add(winMessage);
		}

		if(gamer.lostGame(player)) {
			animation.stop();
			addCurrentScoreToScoresFile(player.getScore(), file);
			//return a lost message
			super.createGroup().getChildren().add(lostMessage);
		}
	}

	private void addCurrentScoreToScoresFile(int score, File file) {
		try {
			BufferedWriter output = new BufferedWriter(new FileWriter(file, true));
			output.newLine();
			output.append("" + score);
			output.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
