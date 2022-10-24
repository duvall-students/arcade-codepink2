package gameComponents;

import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//@author Maggie Bickerstaffe
public class Ball extends GamePlayObject{
	
	private Point2D myVelocity;
    private ImageView myView;
	public int BALL_MIN_SPEED;
    public int BALL_MAX_SPEED;
    
	
	public Ball (Image image) {
		super(image);
		BALL_MIN_SPEED = 100;
	    BALL_MAX_SPEED = 150;
	    
	}
	
    public void stayInWalls (double screenWidth, double screenHeight) {
        // collide all bouncers against the walls
        if (myView.getX() < 0 || myView.getX() > screenWidth - myView.getBoundsInLocal().getWidth()) {
            myVelocity = new Point2D(-myVelocity.getX(), myVelocity.getY());
        }
        if (myView.getY() < 0) {
            myVelocity = new Point2D(myVelocity.getX(), -myVelocity.getY());
        }
    }
    
    public void bounce() {
    	myVelocity = new Point2D(myVelocity.getX(), -myVelocity.getY());
    }
    
    public void makeBallGoFaster() {
    	myVelocity = new Point2D(getRandomInRange(BALL_MIN_SPEED + 100, BALL_MIN_SPEED + 100),
                				 getRandomInRange(BALL_MIN_SPEED + 100, BALL_MIN_SPEED + 1000));
    }

}
