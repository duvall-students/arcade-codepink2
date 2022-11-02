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
	
	   // move the ball by setting x and y over a velocity 
    public void moveBall() {
    	double x = getX();
    	double y = getY();
    	int dx = (int)x;
    	int dy = (int)y;
    	setPosition(dx, dy);
    }

}
