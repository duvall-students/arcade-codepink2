package gameComponents;

import javafx.scene.image.Image;

public class RedBadGuy extends Breaker{

	public int POINTVALUE;
		
	public RedBadGuy(Image image) {
		super(image);
		POINTVALUE = 5;
	}
	
	public RedBadGuy(Image image, int x, int y) {
		super(image, x, y);
    }
}
