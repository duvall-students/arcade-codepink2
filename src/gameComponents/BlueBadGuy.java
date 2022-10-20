package gameComponents;

import javafx.scene.image.Image;

public class BlueBadGuy extends Breaker{

	public int POINTVALUE;
		
	public BlueBadGuy(Image image) {
		super(image);
		POINTVALUE = 5;
	}
	
	public BlueBadGuy(Image image, int x, int y) {
		super(image, x, y);
    }
}