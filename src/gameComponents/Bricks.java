package gameComponents;

import javafx.scene.image.Image;

public class Bricks extends Breaker{
	
	//initialize fields
	
	public int POINTVALUE;
	
	public Bricks (Image image) {
		super(image);
		POINTVALUE = 9;
    }
	
	public Bricks(Image image, int x, int y) {
		super(image, x, y);
    }
}