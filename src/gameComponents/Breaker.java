package gameComponents;

//@author Maggie Bickerstaffe
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class Breaker {
	public int BREAKERWIDTH = 100;
	public int BREAKERHEIGHT = 100;
	public int POINTVALUE = 0;
	protected int BREAKERXPOSITION = 0;
	protected int BREAKERYPOSITION = 0;
	
	private ImageView myView;
	
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
	public boolean visible() {
		return myView.isVisible();
	}
	public void notVisible() {
		myView.setVisible(false);
	}
	public void setVisible() {
		myView.setVisible(true);
	}
	
	public double getWidth() {
		return myView.getFitWidth();
	}
	
	public double getHeight() {
		return myView.getFitHeight();
	}
	
	public void setX(int x) {
		myView.setFitWidth(x);
	}
	
	public double getXPosition() {
		return myView.getX();
	}
	
	public void setY(int y) {
		myView.setFitHeight(y);
	}
	
	public double getYPosition() {
		return myView.getY();
	}
	
	public Node getView () {
	    return myView;
	}
	
	public int getPoints() {
		return POINTVALUE;
	}
	
	public void setPoints(int num) {
		POINTVALUE = num;
	}
	
	
}
