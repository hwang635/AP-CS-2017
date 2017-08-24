import java.awt.Dimension;
import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class Person {
	
	public void draw(PApplet drawer) {
		drawer.stroke(0);
		
		//head
		drawer.ellipse(50, 350, 50, 50);
		//body
		drawer.line(50, 375, 50, 420);
		//arms
		drawer.line(50, 390, 65, 385);
		drawer.line(50, 390, 35, 385);
		//legs
		drawer.line(50, 420, 70, 445);
		drawer.line(50, 420, 30, 445);
	}

}
