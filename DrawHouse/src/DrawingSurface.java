import java.awt.Dimension;
import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class DrawingSurface extends PApplet {
	
	public void draw() {
		
		//for scaling house
		double xRatio = (double)width/500.0;
		double yRatio = (double)height/500.0;
		
		scale((float)xRatio, (float)yRatio);
		
		background(255, 255, 255);
		
		stroke(0, 0, 0);	
		//building
		rect(100, 180, 300, 200);
		stroke(200, 100, 80);
		triangle(100, 180, 250, 100, 400, 180);
		//door
		stroke(200, 120, 5);
		rect(220, 290, 60, 90);
		//windows
		stroke(135, 206, 235);
		rect(135, 220, 50, 50);
		rect(315, 220, 50, 50);
	}
	
	
	public static void main(String args[]) {
		DrawingSurface drawing = new DrawingSurface();
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();

		window.setSize(500, 500);
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
	}
}
