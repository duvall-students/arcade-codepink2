package display;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

// @author: Milli Kearse
//The TextDisplays class holds all text displayed on screen.

public class TextDisplays {
	public Text displayScore(){
		Text displayScore = new Text();
		displayScore.setFill(Color.WHITE);
		displayScore.setFont(Font.font(18));
		displayScore.setX(10);
		displayScore.setY(482);
		displayScore.setText("SCORE: ");

		return displayScore;
	}

	public Text displayLives() {
		Text displayLives = new Text();
		displayLives.setText("LIVES: ");
		displayLives.setFill(Color.WHITE);
		displayLives.setFont(Font.font(18));
		displayLives.setX(10);
		displayLives.setY(465);

		return displayLives;
	}

	public Text lostMessage() {
		Text lostMessage = new Text();		
		return lostMessage;
	}

	public Text displayLostMessage(Text lostMessage) {
		lostMessage.setText("Sorry. You Lose!");
		lostMessage.setFill(Color.WHITE);
		lostMessage.setFont(Font.font(28));
		lostMessage.setX(100);
		lostMessage.setY(350) ;

		return lostMessage;
	}

	public Text winMessage() {
		Text winMessage = new Text();
		return winMessage;
	}

	public Text displayWinMessage(Text winMessage) {
		winMessage.setText("Congrats! You win!");
		winMessage.setFill(Color.WHITE);
		winMessage.setFont(Font.font(28));
		winMessage.setX(100);
		winMessage.setY(350);

		return winMessage;
	}

	public Text topScore(){
		Text topScore = new Text();
		topScore.setText("TOPSCORE: ");
		topScore.setFill(Color.WHITE);
		topScore.setFont(Font.font(18));
		topScore.setX(275);
		topScore.setY(482);

		return topScore;
	}

	public Text level(){
		Text level = new Text();
		level.setText("LEVEL: ");
		level.setFill(Color.WHITE);
		level.setFont(Font.font(18));
		level.setX(275);
		level.setY(465);

		return level;
	}
}
