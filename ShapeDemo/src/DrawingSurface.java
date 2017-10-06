import kush.shapes.Circle;
import kush.shapes.Line;
import processing.core.PApplet;

public class DrawingSurface extends PApplet{

	private PhysicsShape circle;
	private PhysicsShape line;

	public DrawingSurface() {
		circle = new PhysicsShape(new Circle(100, 100, 50));
		line = new PhysicsShape(new Line(10, 10, 50, 50));
	}

	public void draw() {
		background(255);

		circle.draw(this);
	}

	public void mousePressed() {
		circle.setVelocity(1, 1);
		circle.act();
	}

	public void mouseDragged() {
	}
}
