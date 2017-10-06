import kush.shapes.Circle;
import processing.core.PApplet;

public class DrawingSurface extends PApplet{
	
	private PhysicsShape shapeA;
	
	public DrawingSurface() {
		shapeA = new PhysicsShape(new Circle(100, 100, 50));
		
		runSketch();
	}
	
	public void draw() {
		background(255);
		
		shapeA.draw(this);
	}
	
	public void mousePressed() {
		shapeA.setVelocity(1, 1);
	}
	
	public void mouseDragged() {
	}
}
