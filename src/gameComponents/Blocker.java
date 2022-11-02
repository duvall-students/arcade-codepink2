package gameComponents;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Blocker{
	
	//initialize fields
	public int BlOCKERWIDTH = 100;
	public int BlOCKERHEIGHT = 50;
	public int BlOCKERXPOSITION = 140;
	public int BlOCKERYPOSITION = 100;
	private ImageView myView;
	
	public Blocker (Image image) {
        myView = new ImageView(image);
        // make sure it stays a circle
        myView.setFitWidth(BlOCKERWIDTH);
        myView.setFitHeight(BlOCKERHEIGHT);
        // make sure it stays within the bounds
        myView.setX(BlOCKERXPOSITION);
        myView.setY(BlOCKERYPOSITION);
    }
	
	public Blocker(Image image, int x, int y) {
        myView = new ImageView(image);
        // make sure it stays a circle
        myView.setFitWidth(BlOCKERWIDTH);
        myView.setFitHeight(BlOCKERHEIGHT);
        // make sure it stays within the bounds
        myView.setX(x);
        myView.setY(y);
    }
	
	public void setVisible() {
		myView.setVisible(true);
	}
	public boolean visible() {
		return myView.isVisible();
	}
	public void notVisible() {
		myView.setVisible(false);
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
	
	public void setY(int y) {
		myView.setFitHeight(y);
	}
	
    public Node getView() {
        return myView;
    }
    
    public void setXPosition(int x) {
    	myView.setX(x);
    }
    public void setYPosition(int y) {
    	myView.setY(y);
    }
	
	//default constructors 
	//public Rectangle createBrick() {
	//	Rectangle brick = new Rectangle(BRICKWIDTH, BRICKHEIGHT);
	//	brick.setFill(BRICKCOLOR);
	//	return brick;
//	}
	
	//public Rectangle createBrick(int x, int y) {
	//	Rectangle brick = new Rectangle(x, y, BRICKWIDTH, BRICKHEIGHT);
	//	brick.setFill(BRICKCOLOR);
	//	return brick;
	//}
	
}