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
		
		double x = 250.0;
		double r = 188.0;
		double y = 65.0;
		
		lines = new Line(250, 250, x, y);
		lines.setThickness(7);
		lines.changeStrokeShape(2);
		lines.setColour(50);
		lines.draw(this);
		
		double angle = 0;
		
		for(int i = 0; i<40; i++) {
			
			angle += (Math.PI/20.0);
			
			x = 250+r*(Math.cos(angle));
			y = 245+r*Math.sin(angle);
			
			lines.setPoint2(x, y);
			lines.draw(this);
		}
	
		
		
		//vertical == the six rectangles at the front of the illusion
		vertical = new Rectangle(76, 70, 6, 350);
		vertical.setColour(50);
		vertical.draw(this);
		
		//for loop to shift then draw the rectangle 6 times
		for(int i = 0; i<5; i++) {
			vertical.translate(68, 0);
			vertical.draw(this);
		}
		
	}
}
