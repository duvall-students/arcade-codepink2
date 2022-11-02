package display;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import gameComponents.Bricks;
import gameComponents.Bat;
import gameComponents.Ball;
import gameComponents.Player;
import gameComponents.Bullet;
import gameComponents.RedBadGuy;
import gameComponents.BlueBadGuy;
import gameComponents.GreenBadGuy;
import gameComponents.GamePlayObject;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.application.Application;


//@author Maggie Bickerstaffe

//Class deisgned to test my work 
public class TestScene extends SetScene{
	
	Scene myScene;

	public static final int FRAMES_PER_SECOND = 60;
	public static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	public static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
	public static final Paint BACKGROUND = Color.web("#011a52"); //blue
	
	
	//Images
	public static final String BOUNCER_IMAGE = "resources/ball.gif";
	public static final String BULLET_IMAGE = "resources/bullet.gif";
	public static final String BRICK_IMAGE = "resources/brick.gif";
	public static final String REDBADGUY_IMAGE = "resources/RedBadGuy.gif";
	public static final String BLUEBADGUY_IMAGE = "resources/BlueBadGuy.gif";
	public static final String GREENBADGUY_IMAGE = "resources/GreenBadGuy.gif";
	public static final String BAT_IMAGE = "resources/breakout_bat.png";
	
	//Objects
	Player player = new Player();
	File file = new File("SCORES");
	Ball ball;
	Bullet bullet;
	Bricks brick;
	RedBadGuy rbg;
	BlueBadGuy bbg;
	GreenBadGuy gbg;
	Bat bat;
	
	public static void main(String[] args) {
		launch(args);
    }
	
	@Override
	public void start (Stage stage) {
		// attach scene to the stage and display it
		myScene = setUp(width, height, BACKGROUND);
//		mySceneLevel2 = setUpLevel2(width, height, BACKGROUND);
		
		stage.setScene(myScene);
		stage.setTitle("TestScene");
		stage.show();
		
		// attach "game loop" to timeline to play it (basically just calling step() method repeatedly forever)
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> step(SECOND_DELAY, stage));;
		animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
	}
	
	// Test Scene that adds and previews objects 
	public Scene setUp(int width, int height, Paint background) {
		Group gameGroup = new SetScene().createGroup();
		// Test Ball
		try {
			Image imageBall = new Image(new FileInputStream(BOUNCER_IMAGE));
			ball = new Ball(imageBall);
			ball.setPosition(5, 0);
			gameGroup.getChildren().add(ball.getView());
		}
		catch (FileNotFoundException e) {
			System.out.println("image not found");
		}
		// Test Bullet
		try {
			Image imageBullet = new Image(new FileInputStream(BULLET_IMAGE));
			bullet = new Bullet(imageBullet);
			bullet.setPosition(65, 100);
			bullet.setSize(10, 10);
			gameGroup.getChildren().add(bullet.getView());
		}
		catch (FileNotFoundException e) {
			System.out.println("image not found");
		}
		// Test Brick
		try {
			Image imageBrick = new Image(new FileInputStream(BRICK_IMAGE));
			brick = new Bricks(imageBrick);
			brick.setPosition(100, 0);
			gameGroup.getChildren().add(brick.getView());
		}
		catch (FileNotFoundException e) {
			System.out.println("image not found");
		}
		// Test Red Bad Guy
		try {
			Image imageRBG = new Image(new FileInputStream(REDBADGUY_IMAGE));
			rbg = new RedBadGuy(imageRBG);
			rbg.setPosition(175, 0);
			rbg.setY(37);
			gameGroup.getChildren().add(rbg.getView());
		}
		catch (FileNotFoundException e) {
			System.out.println("image not found");
		}
		// Test Blue Bad Buy 
		try {
			Image imageBBG = new Image(new FileInputStream(BLUEBADGUY_IMAGE));
			bbg = new BlueBadGuy(imageBBG);
			bbg.setPosition(250, 0);
			bbg.setY(37);
			gameGroup.getChildren().add(bbg.getView());
		}
		catch (FileNotFoundException e) {
			System.out.println("image not found");
		}
		// Test Green Bad Guy
		try {
			Image imageGBG = new Image(new FileInputStream(GREENBADGUY_IMAGE));
			gbg = new GreenBadGuy(imageGBG);
			gbg.setPosition(300, 0);
			gbg.setY(37);
			gameGroup.getChildren().add(gbg.getView());
		}
		catch (FileNotFoundException e) {
			System.out.println("image not found");
		}
		Scene scene = new Scene(gameGroup, width, height, BACKGROUND);
		return scene;
	}
	
	// test to make sure that ball and bullet move correctly 
	private void step (double elapsedTime, Stage stage) {
		bullet.moveBullet(elapsedTime);
		ball.moveBall(elapsedTime);
	}
	
	
}