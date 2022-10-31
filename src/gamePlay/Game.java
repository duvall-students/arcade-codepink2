package gamePlay;

import javafx.scene.input.KeyCode;
import gameComponents.Player;
import gameComponents.PlayerDevice;

//@author: Shannon Seignious
public abstract class Game {
	
	public static final int MOVER_SPEED = 20;
	
	 public void handleKeyInput (KeyCode code, PlayerDevice playerDevice) {
	    	
	        if (code == KeyCode.LEFT) {
	        	playerDevice.setXPosition(playerDevice.getXPosition() - MOVER_SPEED);
	            if (playerDevice.getXPosition() <= 0) {
	            	playerDevice.setXPosition(0);
	            }
	        }
	        else if (code == KeyCode.RIGHT) {
	        	playerDevice.setXPosition(playerDevice.getXPosition() + MOVER_SPEED);
	            if (playerDevice.getXPosition() >= 235) {
	            	playerDevice.setXPosition(235);
	            }
	        }
	    }
	 
	 public abstract boolean hasWon(int breakerCount);
	 
	 public boolean lostGame(Player player) {
	    	if (player.getLives() <= 0) {
	    		return true;
	    	}
	    	return false;
	    }

}
