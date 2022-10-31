package gameComponents;

// @author Maggie Bickerstaffe
import javafx.scene.image.Image;
//BlueBadGuy Class, extends the breaker superclass but allows for a different point value 
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