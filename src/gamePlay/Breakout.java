package gamePlay;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import gameComponents.Bricks;
import gameComponents.Ball;
import gameComponents.Player;

public class Breakout extends Game {
	
	PlayerDevice bat = new Bat();

	Rectangle brick;
	
	public Paint BRICKCOLOR = Color.web("#db027e");
	public static final Paint BACKGROUND = Color.web("#feb4de");
	
	public static final int BALLXDIRECTION = -2;
	public static final int BALLYDIRECTION = -2;
	
	
    public void handleKeyInput (KeyCode code, Rectangle bat) {
    	
        if (code == KeyCode.LEFT) {
            bat.setX(bat.getX() - MOVER_SPEED);
            if (bat.getX() <= 0) {
            	bat.setX(0);
            }
        }
        else if (code == KeyCode.RIGHT) {
            bat.setX(bat.getX() + MOVER_SPEED);
            if (bat.getX() >= 235) {
            	bat.setX(235);
            }
        }
    }
    
    @Override
    public boolean hasWon(int brickcount) {
    	if (brickcount == 84) {
    		return true;
    	}
    	return false;
    }
    
    public void resetGame(Ball ball) {
    	ball.setPosition(STARTING_X_POSITION, STARTING_Y_POSITION);
    }

}
