package gameComponents;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

public abstract class PlayerDevice {
	
	public int playerDeviceWidth;
	public int playerDeviceHeight;
	// public Paint PLAYERDEVICECOLOR = Color.web("#db027e");
	
	protected ImageView playerDevice;
	
	public void setPosition(int X, int Y) {
		playerDevice.setX(X);
		playerDevice.setY(Y);
	}
	
	public abstract Node getView();

}
