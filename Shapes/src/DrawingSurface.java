import processing.core.PApplet;

public class DrawingSurface extends PApplet{
	
	public Rectangle rect1, rect2, rect3;

	public DrawingSurface() {
		rect1 = new Rectangle();
		rect2 = new Rectangle(0, 80, 400, 160);
		rect3 = new Rectangle(100, -100, 20, -300);
	}
	
	public void draw() {
		rect1.draw(this);
		rect2.draw(this);
		//rect3.draw(this);
	}
}
