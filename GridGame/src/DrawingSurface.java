


import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import processing.core.PApplet;


public class DrawingSurface extends PApplet {

	private Steps board;
	private int runCount;
	private int speed;

	public DrawingSurface() {
		board = new Steps();
		runCount = -1;
		speed = 120;
	}

	// setup() executes when program begins
	//unused method
	public void setup() {
	}

	// statements in draw() executed until the 
	// program is stopped, in sequence. after the last line is read
	// the first line is executed again
	public void draw() { 
		background(255);   // white background
		fill(0);
		textAlign(LEFT);
		textSize(12);

		text("Score: " + board.getScore(), height + 20, 30);
		
		if(board.get2048())
			text("You have won!", height + 20, 50);
		if(board.getLost())
			text("You have lost :( Restart to retry", height + 20, 70);
		
		if (runCount == 0) {
			//board.step(); step is an empty method, but called in tester
			runCount = speed;
		} else if (runCount > 0) {
			runCount--;
		}

		if (board != null) {
			board.draw(this, 0, 0, height, height);
		}

	}
	
	public void keyPressed() {
				
		if(keyCode == KeyEvent.VK_UP)
			board.step(1);
		else if (keyCode == KeyEvent.VK_DOWN)
			board.step(2);
		else if(keyCode == KeyEvent.VK_RIGHT)
			board.step(3);
		else if(keyCode == KeyEvent.VK_LEFT)
			board.step(4);
	}

}