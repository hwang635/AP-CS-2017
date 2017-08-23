import java.awt.Dimension;
import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class House{
	

	public void draw(PApplet drawer) {
		drawer.background(255, 255, 255);

		drawer.stroke(0, 0, 0);	
		//building
		drawer.rect(100, 180, 300, 200);
		drawer.stroke(200, 100, 80);
		drawer.triangle(100, 180, 250, 100, 400, 180);
		//door
		drawer.stroke(200, 120, 5);
		drawer.rect(220, 290, 60, 90);
		//windows
		drawer.stroke(135, 206, 235);
		drawer.rect(135, 220, 50, 50);
		drawer.rect(315, 220, 50, 50);

	}
}