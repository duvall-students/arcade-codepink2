package gameComponents;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

public abstract class PlayerDevice {
	
	public int playerDeviceWidth;
	public int playerDeviceHeight;
	
	protected ImageView playerDevice;
	
	public void setXPosition(double X) {
		playerDevice.setX(X);
	}
	
	public int getXPosition() {
		return (int) playerDevice.getX();
	}
	
	public abstract Node getView();

}
