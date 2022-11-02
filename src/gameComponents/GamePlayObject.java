package gameComponents;

import java.util.Random;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

// @author Maggie Bickerstaffe
public abstract class GamePlayObject{

	//initialize fields
	public static final double OBJECTRADIUS = 50;
	public int OBJECTXPOSITION = 192;
	public int OBJECTYPOSITION = 250;
	public static final int OBJECT_MIN_SPEED = 100;
    public static final int OBJECT_MAX_SPEED = 150;
    private Point2D myVelocity;
    public Circle ball;
    private ImageView myView;
    private Random dice = new Random();
    
    
    public GamePlayObject (Image image) {
        myView = new ImageView(image);
        // make sure it stays a circle
        myView.setFitWidth(OBJECTRADIUS);
        myView.setFitHeight(OBJECTRADIUS);
        // make sure it stays within the bounds
        myView.setX(OBJECTXPOSITION);
        myView.setY(OBJECTYPOSITION);
        // turn speed into velocity that can be updated on bounces
        myVelocity = new Point2D(getRandomInRange(OBJECT_MIN_SPEED, OBJECT_MAX_SPEED),
                                 getRandomInRange(OBJECT_MIN_SPEED, OBJECT_MAX_SPEED));
    }
    
    public void setSize(int x, int y) {
    	myView.setFitWidth(x);
        myView.setFitHeight(y);
    }
    public void setPosition(int X, int Y) {
    	myView.setX(X);
        myView.setY(Y);
    }
    
    public void moveBall(double elapsedTime) {
    	 myView.setX(myView.getX() + myVelocity.getX() * elapsedTime);
         myView.setY(myView.getY() + myVelocity.getY() * elapsedTime);
    }
    
    public boolean dropsOff (double screenWidth, double screenHeight) {
    	if (myView.getY() > screenHeight - myView.getBoundsInLocal().getHeight()) {
    		return true;
    	}
    	return false;
    }
       
    public Node getView () {
        return myView;
    }
    
    public int getRandomInRange (int min, int max) {
        return min + dice.nextInt(max - min) + 1;
    }

}