package display;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import gameComponents.Player;
import gameComponents.RedBadGuy;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

//@author Maggie Bickerstaffe
public class SetScene extends Application{
	
	private Scene myScene;
	
	public static final int FRAMES_PER_SECOND = 60;
	public static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	public static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
	
	public static final int width = 385;
	public static final int height = 500;
	
	public static final String RED_BAD_GUY_IMAGE = "resources/RedBadGuy.gif";
	
	Player player = new Player();
	File file = new File("SCORES");
	
	Timeline animation;
	
	Text displayScore = new TextDisplays().displayScore();
	Text displayLives = new TextDisplays().displayLives();
	Text lostMessage = new TextDisplays().lostMessage();
	Text winMessage = new TextDisplays().winMessage();
	Text topScore = new TextDisplays().topScore();
	Text level = new TextDisplays().level();
	
	public static void main(String[] args) {
		launch(args);
    }
	
	public void start (Stage stage) {
		// attach scene to the stage and display it
		myScene = setUp();
//		mySceneLevel2 = setUpLevel2(width, height, BACKGROUND);
		
		stage.setScene(myScene);
		stage.setTitle("");
		stage.show();
		
		// attach "game loop" to timeline to play it (basically just calling step() method repeatedly forever)
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> step(SECOND_DELAY, stage));;
		animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
	}
	
	public Scene setUp() {
		Group gameGroup = new Group(); 
		displayScore.setText("SCORE: " + player.getScore());
		displayLives.setText("LIVES: " + player.getLives());
		level.setText(level.getText() + "1");
		gameGroup.getChildren().addAll(displayScore, displayLives, lostMessage, winMessage, topScore, level);
		Scene scene = new Scene(gameGroup, width, height);
		return scene;
	}
	
	private void step (double elapsedTime, Stage stage) {
	}
	
	
}
