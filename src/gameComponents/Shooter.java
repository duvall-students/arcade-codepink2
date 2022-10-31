package gameComponents;

import javafx.scene.Node;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//@author: Shannon Seignious
public class Shooter extends PlayerDevice {

	int playerDeviceWidth = 50;
	int playerDeviceHeight = 50;

	private ImageView playerShooter;
	
	public Shooter(Image shooterImage) {
		// Displays ImageView the image as is
		playerShooter = new ImageView();
		playerShooter.setImage(shooterImage);
		// Scales image so that it's smaller
		playerShooter.setFitWidth(playerDeviceWidth);
		playerShooter.setFitHeight(playerDeviceHeight);
		playerShooter.setPreserveRatio(true);
		playerShooter.setSmooth(true);
		playerShooter.setCache(true);
		playerDevice = playerShooter;
	}
	
	@Override
	public Node getView() {
		// Creates player device node
		return playerShooter;
	}

}
