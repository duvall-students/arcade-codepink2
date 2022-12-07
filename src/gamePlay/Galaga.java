package gamePlay;

import gameComponents.PlayerDevice;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import gameComponents.Bullet;

//@author: Shannon Seignious
public class Galaga extends Game {
	
	protected static final int MAX_BADGUY_COUNT = 40;
	
	@Override
	public boolean hasWon(int badGuyCount) {
		// Checks if all bad guys have been cleared
		if (badGuyCount == MAX_BADGUY_COUNT) {
    		return true;
    	}
    	return false;
	}
	
	public void createNewShooterBullet(KeyCode code, PlayerDevice playerDevice, Image bulletImage) {
		 if (code == KeyCode.SPACE) {
			 Bullet bullet = new Bullet(bulletImage);
	     }
	}

}