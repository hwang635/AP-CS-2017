import java.awt.Dimension;
import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class DrawingSurface extends PApplet {
	
	private House house;
	private Person bob;
	
	public DrawingSurface() {
		house = new House();
		bob = new Person();
	}
	
	public void draw() {
		//for scaling
		double xRatio = (double)width/500.0;
		double yRatio = (double)height/500.0;
		scale((float)xRatio, (float)yRatio);
		
		house.draw(this);
		bob.draw(this);
	
	}
	
	public void keyPressed() {
	}

	public void keyReleased() {
		if (keyCode == UP) {
			house.moveUp();
		}
		else if(keyCode == DOWN) {
			house.moveDown();
		}
		else if(keyCode == LEFT) {
			house.moveLeft();
		}
		else if(keyCode == RIGHT) {
			house.moveRight();
		}
		
		redraw();
	}
}
