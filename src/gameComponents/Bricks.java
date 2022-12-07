package gameComponents;

//@author Maggie Bickerstaffe
import javafx.scene.image.Image;
// Brick Class, extends the breaker superclass but allows for a different point value 
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