import kush.shapes.Shape;
import kush.shapes.Shapes2D;
import processing.core.PApplet;

public class PhysicsShape {
	
	//fields
	private Shapes2D boundingShape;
	
	private double vx, vy;
	
	
	
	//constructors
	public PhysicsShape(Shapes2D boundingShape) {
		vx = 0;
		vy = 0;
		
		this.boundingShape = boundingShape;
	}
		
	
	//methods
	public void draw(PApplet drawer) {
		boundingShape.draw(drawer);
	}
	
	public Shape getBoundingShape() {
		return boundingShape;
	}
	
	public void setVelocity(double vx, double vy) {
		this.vx = vx;
		this.vy = vy;
	}
	
	public void act() {
		boundingShape.moveBy(boundingShape.getX(), boundingShape.getY());
		
	}
	
}
