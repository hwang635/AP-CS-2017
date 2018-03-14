import java.awt.event.KeyEvent;

import processing.core.PApplet;
import processing.event.MouseEvent;


public class DrawingSurface2 extends PApplet {

	//private KochCurve curve;
	//private KochSnowflake curve;
	private BoxFractal box;
	private int level, length;

	public DrawingSurface2() {
		level = 0;
		length = 100;
		//curve = new KochCurve (level,length);
		//curve = new KochSnowflake (level,length);
		box = new BoxFractal(level, length);
	}

	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {

	}

	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() { 
		background(255);   // Clear the screen with a white background

		textSize(12);
		fill(0);
		text("Use the mouse wheel to change length, use UP/DOWN keys to change level.",0,15);

		stroke(0);
		box.draw(this);		
	}


	public void mouseWheel(MouseEvent event) {
		int num = event.getCount();
		length -= num*10;
		//curve = new KochCurve(level,length);
		//curve = new KochSnowflake(level,length);
		box = new BoxFractal(level, length);
	}

	public void keyPressed() {
		if (keyCode == KeyEvent.VK_UP) {
			level++;
			//curve = new KochCurve(level,length);
			//curve = new KochSnowflake(level,length);
			box = new BoxFractal(level, length);
		} else if (keyCode == KeyEvent.VK_DOWN) {
			level--;
			//curve = new KochCurve(level,length);
			box = new BoxFractal(level, length);
		}
	}


}









