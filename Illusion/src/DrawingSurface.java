import helen.shapes.Rectangle;
import processing.core.PApplet;

public class DrawingSurface extends PApplet{
	
	private Rectangle whiteBackground, blackBackground;
	
	public DrawingSurface() {
		blackBackground = new Rectangle(0, 0, 700, 500);
		whiteBackground = new Rectangle(0,0, 620, 500);
	}
	
	public void draw() {
		blackBackground.changeColour(true);
		blackBackground.setColour(0);
		blackBackground.draw(this);
		whiteBackground.changeColour(true);
		whiteBackground.setColour(255);
		whiteBackground.draw(this);
	
		
	}
}
