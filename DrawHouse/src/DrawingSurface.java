import java.awt.Dimension;
import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class DrawingSurface extends PApplet {
	
	private House house;
	
	public DrawingSurface() {
		house = new House();
	}
	
	public void draw() {
		//for scaling
		double xRatio = (double)width/500.0;
		double yRatio = (double)height/500.0;
		scale((float)xRatio, (float)yRatio);
		
		house.draw(this);
	
	}
}
