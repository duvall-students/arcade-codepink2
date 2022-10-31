package gameComponents;

//@author Maggie Bickerstaffe
import javafx.scene.image.Image;
//GreenBadGuy Class, extends the breaker superclass but allows for a different point value 
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