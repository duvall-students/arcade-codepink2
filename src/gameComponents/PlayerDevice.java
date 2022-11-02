package gameComponents;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//@author: Shannon Seignious
public abstract class PlayerDevice {
	
	//initialize fields
	public int playerDeviceWidth;
	public int playerDeviceHeight;
	
	protected ImageView playerDevice;
	
	// Player Device constructor
	public PlayerDevice(Image playerDeviceImage) {
		// Displays ImageView the image as is
		playerDevice = new ImageView();
		playerDevice.setImage(playerDeviceImage);
		// Scales image so that it's smaller
		playerDevice.setFitWidth(playerDeviceWidth);
		playerDevice.setFitHeight(playerDeviceHeight);
		playerDevice.setPreserveRatio(true);
		playerDevice.setSmooth(true);
		playerDevice.setCache(true);
	}
	
	// initializes x position of device
	public void setXPosition(double X) {
		playerDevice.setX(X);
	}
	
	public int getXPosition() {
		return (int) playerDevice.getX();
	}
	
	public abstract Node getView();

}