package gameComponents;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//@author: Shannon Seignious
public class Shooter extends PlayerDevice {

	//initialize fields
	int playerDeviceWidth = 50;
	int playerDeviceHeight = 50;

	private ImageView playerShooter;
	
	// Shooter Constructor
	public Shooter(Image shooterImage) {
		super(shooterImage);
		playerDevice = playerShooter;
	}
	
	@Override
	public Node getView() {
		// Creates player device node
		return playerDevice;
	}

}