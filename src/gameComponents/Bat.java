package gameComponents;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//@author: Shannon Seignious
public class Bat extends PlayerDevice {

	//initialize fields
	int playerDeviceWidth = 150;
	int playerDeviceHeight = 30;

	private ImageView playerBat;

	// Bat Constructor
	public Bat(Image batImage) {
		super(batImage);
		playerDevice = playerBat;

	}

	@Override
	public Node getView() {
		// Creates player device node
		return playerDevice;
	}
}
