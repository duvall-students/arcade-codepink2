package display;

import java.io.File;
import gameComponents.Player;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//@author Maggie Bickerstaffe

// Class used to start the application class and create 
// a general text display group. Is called by BreakoutScene
// and GalagaScene 
public class SetScene extends Application{
	
	private Scene myScene;
	
	public static final int width = 385;
	public static final int height = 500;
	
	
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
	
	//empty classes needed for Application 
	public void start (Stage stage) {
	}
	
	//empty classes needed for Application 
	public Scene setUp(Group gameGroup) {
		return myScene;
	}
	
	//group to be implemented in BreakoutScene and GalagaScene includes Text Displays
	public Group createGroup() {
		Group gameGroup = new Group(); 
		displayScore.setText("SCORE: " + player.getScore());
		displayLives.setText("LIVES: " + player.getLives());
		level.setText(level.getText() + "1");
		gameGroup.getChildren().addAll(displayScore, displayLives, lostMessage, winMessage, topScore, level);
		
		return gameGroup;
	}
}
