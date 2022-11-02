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

import gameComponents.Ball;
import gameComponents.Bat;
import gameComponents.Bricks;
import gameComponents.Player;
import gameComponents.PlayerDevice;
import gamePlay.Breakout;
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
public class BreakoutScene extends SetScene{

	public static final String TITLE = "Breakout";
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
	protected int BRICKCOUNT = 0;

	public static final String BOUNCER_IMAGE = "resources/ball.gif";
	public static final String BRICK_IMAGE = "resources/brick.gif";
	public static final String CHANGED_BALL_COLOR_IMAGE = "resources/blueBall.gif";
	public static final String BAT_IMAGE = "resources/breakout_bat.gif";
	
	File file = new File("TOPSCORE");
	private List<Bricks> myBricks;

	//Game gamer = new Game();
	Breakout gamer = new Breakout();

	Bricks brick;
	//Rectangle bat;
	PlayerDevice bat;
	Ball ball;
	Player player;
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
		myScene = setUp(width, height, BACKGROUND);
		stage.setScene(myScene);
		stage.setTitle(TITLE);
		stage.show();
		// attach "game loop" to timeline to play it (basically just calling step() method repeatedly forever)
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> step(SECOND_DELAY, stage));;
		animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
	}


	public Scene setUp (int width, int height, Paint background) {
		Group root = new Group();
		player = new Player();
		try {
			Image imageBall = new Image(new FileInputStream(BOUNCER_IMAGE));
			ball = new Ball(imageBall);
			root.getChildren().add(ball.getView());
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			Image imageBat = new Image(new FileInputStream(BAT_IMAGE));
			bat = new Bat(imageBat);
			root.getChildren().add(bat.getView());
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int BRICKXPOSITION = 0;
		int BRICKYPOSITION = 0;

		myBricks = new ArrayList<>();   
		while (BRICKYPOSITION <= height/2.5) {
			while (BRICKXPOSITION <= width) {
				try {
					Image imageBrick = new Image(new FileInputStream(BRICK_IMAGE));
					brick = new Bricks(imageBrick, BRICKXPOSITION, BRICKYPOSITION);
				}
				catch (FileNotFoundException e) {}
				myBricks.add(brick);
				root.getChildren().add(brick.getView()); 
				BRICKXPOSITION += brick.getWidth() + 5;   
			}
			this.brick.setPoints(brick.getPoints() - 1);
			BRICKYPOSITION += brick.getHeight() + 5; 
			BRICKXPOSITION = 0;
		}

		//calls the SetScene class to load all text displays.
		super.createGroup();
		super.createGroup().getChildren().addAll(displayScore, topScore, level);
		
		Scene scene = new Scene(root, width, height, background);
		//respond to input 
		scene.setOnKeyPressed(e -> gamer.handleKeyInput(e.getCode(), bat));
		return scene;
	}

	private void step (double elapsedTime, Stage stage) {
		int count = 0;

		ball.moveBall(elapsedTime);
		for (Bricks brick : myBricks) {
			if (brick.getView().getBoundsInParent().intersects(ball.getView().getBoundsInParent()) && brick.visible()) {
				brick.notVisible();
				ball.bounce();
				BRICKCOUNT += 1;
				player.setScore(brick.getPoints() + player.getScore());
				displayScore.setText("SCORE: " + String.valueOf(player.getScore()));
				System.out.println(player.getScore());

				//once all bricks are cleared, go to level one
				if(player.getScore() == 477) {
					count += 1;
					try {
						levelOneScene = levelOne(width, height, LEVEL_ONE_BACKGROUND);
						stage.setScene(levelOneScene);
						Image newBallImage = new Image(new FileInputStream(CHANGED_BALL_COLOR_IMAGE));
						// Power Up - changes color of ball and makes ball move faster after score gets to 50
						ball.changeBallColor(newBallImage);
						ball.makeBallGoFaster();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}

				//once all bricks are cleared in level 1, go to level 2
				if(player.getScore() == 954) {
					count += 1;
					levelTwoScene = levelTwo(width, height, LEVEL_TWO_BACKGROUND);
					stage.setScene(levelTwoScene);
				}

				//once all bricks are cleared in level 2, go to level 3
				if(player.getScore() == 1431) {
					count += 1;
					levelThreeScene = levelThree(width, height, LEVEL_THREE_BACKGROUND);
					stage.setScene(levelThreeScene);
				}
			}
		}

		/*if (bat.getBoundsInParent().intersects(ball.getView().getBoundsInParent())) {
			ball.bounce();
		}	*/
		ball.stayInWalls(myScene.getWidth(), myScene.getHeight());

		if (ball.dropsOff(myScene.getWidth(), myScene.getHeight())){
			player.lifeLost();
			displayLives.setText("LIVES: " + String.valueOf(player.getLives()));
			gamer.resetGame(ball);
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

	public Scene levelOne(int width, int height, Paint background) {
		Group root = new Group();
		player = new Player();
		try {
			Image imageBall = new Image(new FileInputStream(BOUNCER_IMAGE));
			ball = new Ball(imageBall);
			root.getChildren().add(ball.getView());
		}
		catch (FileNotFoundException e) {}
		//bat = new Bat().createBat();

		int BRICKXPOSITION = 0;
		int BRICKYPOSITION = 0;

		myBricks = new ArrayList<>();   
		while (BRICKYPOSITION <= height/2.5) {
			while (BRICKXPOSITION <= width) {
				try {
					Image imageBrick = new Image(new FileInputStream(BRICK_IMAGE));
					brick = new Bricks(imageBrick, BRICKXPOSITION, BRICKYPOSITION);
				}
				catch (FileNotFoundException e) {}
				myBricks.add(brick);
				root.getChildren().add(brick.getView()); 
				BRICKXPOSITION += brick.getWidth() + 5;   
			}
			this.brick.setPoints(brick.getPoints() - 1);
			BRICKYPOSITION += brick.getHeight() + 5; 
			BRICKXPOSITION = 0;
		}


		//calls the SetScene class to load all text display
		super.createGroup();
		//super.createGroup().getChildren().addAll(displayScore, topScore, level);
		
		Scene scene1 = new Scene(root, width, height, background);
		//respond to input 
		scene1.setOnKeyPressed(e -> gamer.handleKeyInput(e.getCode(), bat));
		return scene1;
	}

	public Scene levelTwo(int width, int height, Paint background) {
		Group root = new Group();
		player = new Player();
		try {
			Image imageBall = new Image(new FileInputStream(BOUNCER_IMAGE));
			ball = new Ball(imageBall);
			root.getChildren().add(ball.getView());
		}
		catch (FileNotFoundException e) {}
		//bat = new Bat().createBat();

		int BRICKXPOSITION = 0;
		int BRICKYPOSITION = 0;

		myBricks = new ArrayList<>();   
		while (BRICKYPOSITION <= height/2.5) {
			while (BRICKXPOSITION <= width) {
				try {
					Image imageBrick = new Image(new FileInputStream(BRICK_IMAGE));
					brick = new Bricks(imageBrick, BRICKXPOSITION, BRICKYPOSITION);
				}
				catch (FileNotFoundException e) {}
				myBricks.add(brick);
				root.getChildren().add(brick.getView()); 
				BRICKXPOSITION += brick.getWidth() + 5;   
			}
			this.brick.setPoints(brick.getPoints() - 1);
			BRICKYPOSITION += brick.getHeight() + 5; 
			BRICKXPOSITION = 0;
		}

		//calls the SetScene class to load all text display
		super.createGroup();
		//super.createGroup().getChildren().addAll(displayScore, topScore, level);
		
		Scene scene1 = new Scene(root, width, height, background);
		//respond to input 
		scene1.setOnKeyPressed(e -> gamer.handleKeyInput(e.getCode(), bat));
		return scene1;
	}

	public Scene levelThree(int width, int height, Paint background) {
		Group root = new Group();
		player = new Player();
		try {
			Image imageBall = new Image(new FileInputStream(BOUNCER_IMAGE));
			ball = new Ball(imageBall);
			root.getChildren().add(ball.getView());
		}
		catch (FileNotFoundException e) {}
		//bat = new Bat().createBat();

		int BRICKXPOSITION = 0;
		int BRICKYPOSITION = 0;

		myBricks = new ArrayList<>();   
		while (BRICKYPOSITION <= height/2.5) {
			while (BRICKXPOSITION <= width) {
				try {
					Image imageBrick = new Image(new FileInputStream(BRICK_IMAGE));
					brick = new Bricks(imageBrick, BRICKXPOSITION, BRICKYPOSITION);
				}
				catch (FileNotFoundException e) {}
				myBricks.add(brick);
				root.getChildren().add(brick.getView()); 
				BRICKXPOSITION += brick.getWidth() + 5;   
			}
			this.brick.setPoints(brick.getPoints() - 1);
			BRICKYPOSITION += brick.getHeight() + 5; 
			BRICKXPOSITION = 0;
		}


		//calls the SetScene class to load all text display
		super.createGroup();
		//super.createGroup().getChildren().addAll(displayScore, topScore, level);
		
		Scene scene1 = new Scene(root, width, height, background);
		//respond to input 
		scene1.setOnKeyPressed(e -> gamer.handleKeyInput(e.getCode(), bat));
		return scene1;
	}
}
