package display;

// @author Maggie Bickerstaffe
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class SetScene extends Application{
	
	private Scene myScene;
	
	public static final int FRAMES_PER_SECOND = 60;
	public static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;
	public static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
	
	public static final int width = 385;
	public static final int height = 500;
	
	Timeline animation;
	
	public static void main(String[] args) {
		launch(args);
    }
	
	@Override
	public void start (Stage stage) {
		// attach scene to the stage and display it
		myScene = setUp();
//		mySceneLevel2 = setUpLevel2(width, height, BACKGROUND);
		
		stage.setScene(myScene);
		stage.setTitle("Breakout");
		stage.show();
		
		// attach "game loop" to timeline to play it (basically just calling step() method repeatedly forever)
		KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> step(SECOND_DELAY, stage));;
		animation = new Timeline();
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.getKeyFrames().add(frame);
		animation.play();
	}
	
	public Group setGroup() {
		Group gameGroup = new Group();
		return gameGroup;
	}
	
	public Scene setUp() {
		Group root = setGroup();
		Scene scene = new Scene(root, width, height);
		return scene;
	}
	
	private void step (double elapsedTime, Stage stage) {
	}
	
	
}
