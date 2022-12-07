package gameComponents;

import java.util.Random;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// @author Maggie Bickerstaffe

//GamePlay Object Class, superclass of ball and bullet 
public class GamePlayObject{

	//initialize fields
	private static final double OBJECTRADIUS = 50;
	private int OBJECTXPOSITION = 192;
	private int OBJECTYPOSITION = 250;
	private static final int OBJECT_MIN_SPEED = 100;
	private static final int OBJECT_MAX_SPEED = 150;
    private Point2D myVelocity;
    private ImageView myView;
    private Random dice = new Random();
    
    
    // GamePlayObject constructor 
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
    
    // sets the size
    public void setSize(int x, int y) {
    	myView.setFitWidth(x);
        myView.setFitHeight(y);
    }
    
    // sets the x and y positions 
    public void setPosition(int X, int Y) {
    	myView.setX(X);
        myView.setY(Y);
    }
    
    // is the GamePlayObject off the scene?
    public boolean dropsOff (double screenWidth, double screenHeight) {
    	if (myView.getY() > screenHeight - myView.getBoundsInLocal().getHeight()) {
    		return true;
    	}
    	return false;
    }
   
   // moves ball downwards at angles 
   public void moveBall(double elapsedTime) {
   	 myView.setX(myView.getX() + myVelocity.getX() * elapsedTime);
     myView.setY(myView.getY() + myVelocity.getY() * elapsedTime);
   } 
   
   // moves bullet straight upwards 
   public void moveBullet(double elapsedTime) {
	 myView.setY(myView.getY() - myVelocity.getY() * elapsedTime);
   } 
       
    public double getX() {
    	double x = myView.getX();
    	return x;
    }
    
    public double getY() {
    	double y = myView.getY();
    	return y;
    }
    
    public Node getView () {
        return myView;
    }
    
    public int getRandomInRange (int min, int max) {
        return min + dice.nextInt(max - min) + 1;
    }

}