package gamePlay;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import gameComponents.Ball;

//@author: Shannon Seignious
public class Breakout extends Game {

	Rectangle brick;
	
	public Paint BRICKCOLOR = Color.web("#db027e");
	public static final Paint BACKGROUND = Color.web("#feb4de");
	
	public static final int BALLXDIRECTION = -2;
	public static final int BALLYDIRECTION = -2;
    
    @Override
    public boolean hasWon(int brickcount) {
    	if (brickcount == 84) {
    		return true;
    	}
    	return false;
    }
    
    public void resetGame(Ball ball) {
    	ball.setPosition(192, 250);
    }
    

}
