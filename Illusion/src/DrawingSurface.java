import helen.shapes.Line;
import helen.shapes.Rectangle;
import processing.core.PApplet;

public class DrawingSurface extends PApplet{
	
	private Rectangle whiteBackground, blackBackground;
	private Rectangle vertical;
	private Line lines;
	
	public DrawingSurface() {
		blackBackground = new Rectangle(0, 0, 630, 500);
		whiteBackground = new Rectangle(0,0, 500, 500);
	}
	
	public void draw() {
		blackBackground.changeColour(true);
		blackBackground.setColour(0);
		blackBackground.draw(this);
		whiteBackground.changeColour(true);
		whiteBackground.setColour(255);
		whiteBackground.draw(this);
		
		lines = new Line(250, 250, 250, 70);
		lines.setThickness(7);
		lines.setColour(50);
		lines.draw(this);
		
	
	
		
		//vertical == the six rectangles at the front of the illusion
		vertical = new Rectangle(76, 70, 10, 350);
		vertical.setColour(50);
		vertical.draw(this);
		
		//for loop to shift then draw the rectangle 6 times
		for(int i = 0; i<5; i++) {
			vertical.translate(68, 0);
			vertical.draw(this);
		}
	
		
	}
}
