package gameComponents;

import javafx.scene.image.Image;

// @author Maggie Bickerstaffe
public class Bullet extends GamePlayObject{
	
	public double OBJECTRADIUS;
	
	public Bullet (Image image) {
		super(image);
		OBJECTRADIUS = 3;
	}

}
