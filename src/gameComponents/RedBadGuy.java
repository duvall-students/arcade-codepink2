package gameComponents;

//@author Maggie Bickerstaffe
import javafx.scene.image.Image;
//RedBadGuy Class, extends the breaker superclass but allows for a different point value 
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
