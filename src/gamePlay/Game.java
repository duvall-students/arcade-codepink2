package gamePlay;

import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import gameComponents.PlayerDevice;

public class Game {
	
	public static final int MOVER_SPEED = 15;
	
	 public void handleKeyInput (KeyCode code, PlayerDevice playerDevice) {
	    	
	        if (code == KeyCode.LEFT) {
	        	playerDevice.setX(playerDevice.getX() - MOVER_SPEED);
	            if (playerDevice.getX() <= 0) {
	            	playerDevice.setX(0);
	            }
	        }
	        else if (code == KeyCode.RIGHT) {
	        	playerDevice.setX(playerDevice.getX() + MOVER_SPEED);
	            if (playerDevice.getX() >= 235) {
	            	playerDevice.setX(235);
	            }
	        }
	    }
	 
	 public boolean hasWon(int breakerCount);

}
