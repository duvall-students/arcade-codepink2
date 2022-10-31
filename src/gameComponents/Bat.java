package gameComponents;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

//@author: Shannon Seignious
public class Bat extends PlayerDevice {

	//initialize fields
	int playerDeviceWidth = 150;
	int playerDeviceHeight = 30;

	private ImageView playerBat;

	public Bat(Image batImage) {
		// Displays ImageView the image as is
		playerBat = new ImageView();
		playerBat.setImage(batImage);
		// Scales image so that it's smaller
		playerBat.setFitWidth(playerDeviceWidth);
		playerBat.setFitHeight(playerDeviceHeight);
		playerBat.setPreserveRatio(true);
		playerBat.setSmooth(true);
		playerBat.setCache(true);
		playerDevice = playerBat;

	}

	@Override
	public Node getView() {
		// Creates player device node
		return playerDevice;
	}
}
