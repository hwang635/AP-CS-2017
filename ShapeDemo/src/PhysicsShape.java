import kush.shapes.Circle;
import kush.shapes.Shape;
import kush.shapes.Shapes2D;
import processing.core.PApplet;

public class PhysicsShape {
	
	//fields
	private Shape boundingShape;
	
	private double vx, vy;
	private int typeOfShape; //keeps track of type of shape
	
	
	//constructors
	public PhysicsShape(Shapes2D boundingShape) {
		vx = 0;
		vy = 0;
		
		this.boundingShape = boundingShape;
	}
		
	
	//methods
	public void draw(PApplet drawer) {
		Shapes2D newShape = (Shapes2D)boundingShape;
		newShape.draw(drawer);
	}
	
	public Shape getBoundingShape() {
		return boundingShape;
	}
	

	//circle will return to starting position if dragged
	public void returnCircle(Circle circle) {
		circle.getX();
		circle.getY();
		
		
		
		
	}
	
	public void setVelocity(double vx, double vy) {
		this.vx = vx;
		this.vy = vy;
	}
	
	public void act() {
		//boundingShape.moveBy(boundingShape.getX(), boundingShape.getY());
		boundingShape.moveBy(vx, vy);
	}
	
}
