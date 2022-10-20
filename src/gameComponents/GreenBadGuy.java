package gameComponents;

import javafx.scene.image.Image;

public class GreenBadGuy extends Breaker{

	public int POINTVALUE;
		
	public GreenBadGuy(Image image) {
		super(image);
		POINTVALUE = 10;
	}
	
	public GreenBadGuy(Image image, int x, int y) {
		super(image, x, y);
    }
}