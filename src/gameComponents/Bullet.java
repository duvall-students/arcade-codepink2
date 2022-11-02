package gameComponents;

import javafx.scene.image.Image;

// @author Maggie Bickerstaffe

// bullet Object class for Galaga 
public class Bullet extends GamePlayObject{
	
	public double OBJECTRADIUS;
	
	public Bullet (Image image) {
		super(image);
		OBJECTRADIUS = 3;
	}

}
