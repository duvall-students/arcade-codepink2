package gameComponents;

//@author Maggie Bickerstaffe

// Breaker Class
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Breaker {
	public int BREAKERWIDTH = 60;
	public int BREAKERHEIGHT = 20;
	public int POINTVALUE = 0;
	protected int BREAKERXPOSITION = 0;
	protected int BREAKERYPOSITION = 0;
	
	private ImageView myView;
	
	//  Breaker constructor 
	public Breaker(Image image) {
        myView = new ImageView(image);
        // make sure it stays a circle
        myView.setFitWidth(BREAKERWIDTH);
        myView.setFitHeight(BREAKERHEIGHT);
        // make sure it stays within the bounds
        myView.setX(BREAKERXPOSITION);
        myView.setY(BREAKERYPOSITION);
    }
	
	public Breaker(Image image, int x, int y) {
        myView = new ImageView(image);
        // make sure it stays a circle
        myView.setFitWidth(BREAKERWIDTH);
        myView.setFitHeight(BREAKERHEIGHT);
        // make sure it stays within the bounds
        myView.setX(x);
        myView.setY(y);
    }
	
	// sets breaker position on scene 
	public void setPosition(int x, int y) {
        myView.setX(x);
        myView.setY(y);
	}
	
	// is the breaker visible? 
	public boolean visible() {
		return myView.isVisible();
	}
	
	// is the breaker notVisibile?
	public void notVisible() {
		myView.setVisible(false);
	}
	
	// sets the breaker to visible 
	public void setVisible() {
		myView.setVisible(true);
	}
	
	// returns breaker's width 
	public double getWidth() {
		return myView.getFitWidth();
	}
	
	// returns breaker's height 
	public double getHeight() {
		return myView.getFitHeight();
	}
	
	// sets breaker's x-position 
	public void setX(int x) {
		myView.setFitWidth(x);
	}
	
	// returns breaker's x-position 
	public double getXPosition() {
		return myView.getX();
	}
	
	// sets breaker's y-position 
	public void setY(int y) {
		myView.setFitHeight(y);
	}
	
	// returns breaker's y-position 
	public double getYPosition() {
		return myView.getY();
	}
	
	public Node getView () {
	    return myView;
	}
	
	// returns breaker's points value 
	public int getPoints() {
		return POINTVALUE;
	}
	
	// sets breaker's points value 
	public void setPoints(int num) {
		POINTVALUE = num;
	}
	
	
}
