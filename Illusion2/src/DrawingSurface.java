import helen.shapes.Circle;
import helen.shapes.Rectangle;
import processing.core.PApplet;

public class DrawingSurface extends PApplet{
	
	private Rectangle whiteBackground, blackBackground;
	private Circle circles;
	private Rectangle rect1, rect2, rect3, rect4;
	
	public DrawingSurface() {
		blackBackground = new Rectangle(0, 0, 630, 500);
		whiteBackground = new Rectangle(0,0, 500, 500);
		
		rect1 = new Rectangle(66, 60, 7, 360);
		rect2 = new Rectangle(66, 414, 366, 7);
		rect3 = new Rectangle(425, 60, 7, 360);
		rect4 = new Rectangle(66, 60, 360, 7);
	}
	
	public void draw() {
		blackBackground.changeColour(true);
		blackBackground.setColour(0);
		blackBackground.draw(this);
		whiteBackground.changeColour(false);
		whiteBackground.setStrokeWeight(0);
		whiteBackground.setColour(255, 255, 255);
		whiteBackground.draw(this);
		
		//variables for circle
		int width = 455;
		int count = 0; //counts number of circles drawn
	
		//loop, draws increasingly smaller circles
		//fills in odd circles with white and even circles with black
		while(width >= 50) {
			count++;
			width -= 15;
			circles = new Circle(250, 240, width); //starts large, then radius decreases
			
			if(count%2 == 0) {
				circles.changeColour(false);
				circles.setColour(255, 255, 255); //even circle = black
			}
			else
				circles.setColour(0); //odd circle = white
			
			circles.draw(this);
		}
		
		//code for the purple box
		rect1.changeColour(false);
		rect1.setStrokeWeight(0);
		rect1.setColour(128, 9, 168);
		rect1.draw(this);
		
		rect2.changeColour(false);
		rect2.setStrokeWeight(0);
		rect2.setColour(128, 9, 168);
		rect2.draw(this);
		
		rect3.changeColour(false);
		rect3.setStrokeWeight(0);
		rect3.setColour(128, 9, 168);
		rect3.draw(this);
		
		rect4.changeColour(false);
		rect4.setStrokeWeight(0);
		rect4.setColour(128, 9, 168);
		rect4.draw(this);
	}
}
