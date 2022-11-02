package display;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import gameComponents.Bricks;
import gameComponents.Ball;
import gameComponents.Bat;
import gameComponents.Player;
import gameComponents.Bullet;
import gameComponents.RedBadGuy;
import gameComponents.Shooter;
import gameComponents.BlueBadGuy;
import gameComponents.GreenBadGuy;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;


//@author Maggie Bickerstaffe
public class TestScene extends SetScene{

	Scene myScene;

	//Images
	public static final String BOUNCER_IMAGE = "resources/ball.gif";
	public static final String BULLET_IMAGE = "resources/bullet.gif";
	public static final String BRICK_IMAGE = "resources/brick.gif";
	public static final String BAT_IMAGE = "resources/breakout_bat.gif";
	public static final String REDBADGUY_IMAGE = "resources/RedBadGuy.gif";
	public static final String BLUEBADGUY_IMAGE = "resources/BlueBadGuy.gif";
	public static final String GREENBADGUY_IMAGE = "resources/GreenBadGuy.gif";
	public static final String SHOOTER_IMAGE = "resources/galaga_shooter.png";

	//Objects
	Player player = new Player();
	File file = new File("SCORES");
	Ball ball;
	Bullet bullet;
	Bricks brick;
	RedBadGuy redBadGuy;
	BlueBadGuy blueBadGuy;
	Bat bat;
	Shooter shooter;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start (Stage stage) {
		// attach scene to the stage and display it
		myScene = setUp(width, height, BACKGROUND);

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


	public Scene setUp(int width, int height, Paint background) {
		Group gameGroup = new SetScene().createGroup();
		// Test Ball
		try {
			Image imageBall = new Image(new FileInputStream(BOUNCER_IMAGE));
			Ball ball = new Ball(imageBall);
			ball.setPosition(5, 0);
			gameGroup.getChildren().add(ball.getView());
		}
		catch (FileNotFoundException e) {
			System.out.println("image not found");
		}
		// Test Bullet
		try {
			Image imageBullet = new Image(new FileInputStream(BULLET_IMAGE));
			Bullet bullet = new Bullet(imageBullet);
			bullet.setPosition(65, 0);
			bullet.setSize(10, 10);
			gameGroup.getChildren().add(bullet.getView());
		}
		catch (FileNotFoundException e) {
			System.out.println("image not found");
		}
		// Test Brick
		try {
			Image imageBrick = new Image(new FileInputStream(BRICK_IMAGE));
			Bricks brick = new Bricks(imageBrick);
			brick.setPosition(100, 0);
			gameGroup.getChildren().add(brick.getView());
		}
		catch (FileNotFoundException e) {
			System.out.println("image not found");
		}
		// Test Red Bad Guy
		try {
			Image imageRBG = new Image(new FileInputStream(REDBADGUY_IMAGE));
			RedBadGuy rbg = new RedBadGuy(imageRBG);
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
			BlueBadGuy bbg = new BlueBadGuy(imageBBG);
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
			GreenBadGuy gbg = new GreenBadGuy(imageGBG);
			gbg.setPosition(300, 0);
			gbg.setY(37);
			gameGroup.getChildren().add(gbg.getView());
		}
		catch (FileNotFoundException e) {
			System.out.println("image not found");
		}

		// Test Bat
		try {
			Image imageBat = new Image(new FileInputStream(BAT_IMAGE));
			Bat bat = new Bat(imageBat);
			bat.setXPosition(10.0);
			gameGroup.getChildren().add(bat.getView());
		}
		catch (FileNotFoundException e) {
			System.out.println("image not found");
		}
		
		// Test Shooter
		try {
			Image imageShooter = new Image(new FileInputStream(SHOOTER_IMAGE));
			Shooter shooter = new Shooter(imageShooter);
			shooter.setXPosition(5.0);
			gameGroup.getChildren().add(shooter.getView());
		}
		catch (FileNotFoundException e) {
			System.out.println("image not found");
		}
		
		Scene scene = new Scene(gameGroup, width, height, BACKGROUND);
		return scene;
	}

	private void step (double elapsedTime, Stage stage) {
	}

}