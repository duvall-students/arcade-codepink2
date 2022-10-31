package gamePlay;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import gameComponents.Ball;

//@author: Shannon Seignious
public class Breakout extends Game {
	
	public Paint BRICKCOLOR = Color.web("#db027e");
	public static final Paint BACKGROUND = Color.web("#feb4de");
	
	protected static final int BALLXDIRECTION = -2;
	protected static final int BALLYDIRECTION = -2;
	protected static final int MAXBRICKCOUNT = 84;
	protected static final int STARTING_X_POSITION = 192;
	protected static final int STARTING_Y_POSITION = 250;
    
	
    @Override
    public boolean hasWon(int brickcount) {
    	if (brickcount == MAXBRICKCOUNT) {
    		return true;
    	}
    	return false;
    }
    
    public void resetGame(Ball ball) {
    	ball.setPosition(STARTING_X_POSITION, STARTING_Y_POSITION);
    }

}
