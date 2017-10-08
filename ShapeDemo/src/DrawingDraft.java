import kush.shapes.Circle;
import kush.shapes.Line;
import processing.core.PApplet;

public class DrawingDraft extends PApplet{

	private PhysicsShape circle;
	private PhysicsShape line;
	private Circle c1;
	private Line l1;

	private boolean circleDragged;

	public DrawingDraft() {
		c1 = new Circle(100, 100, 50);
		//circle = new PhysicsShape(c1);

		l1 = new Line(10, 10, 50, 50);
		//line = new PhysicsShape(l1);

		circleDragged = false;
	}

	public void draw() {
		background(255);

		circle = new PhysicsShape(c1);
		l1.borderThickness(5);
		l1.draw(this);
		line = new PhysicsShape(l1);

		circle.draw(this);
		line.draw(this);

		if(circleDragged == true) {
			double endX = Math.random()*500;
			double endY = Math.random()*500;
			double vx = (endX-c1.getX())/10.0;
			double vy = (endY-c1.getY())/10.0;

			circle.setVelocity(vx, vy); //10 = value for time

			circle.act();
			//System.out.println("x is" + vx + " y is " + vy);
		}
	}

	public void mousePressed() {
		if(mouseButton == LEFT) {
			System.out.println("left");
		}

		if (mouseButton == RIGHT) {//if right clicked, will make a new line/move the line to mouse coordinates
			l1 = new Line(mouseX,mouseY,mouseX,mouseY);
			System.out.println("right");
			this.redraw();
		}
	}

	public void mouseDragged() {
		//left click is for circle
		if(mouseButton == LEFT) {
			if(c1.isPointInside(mouseX, mouseY)) //makes sure that was clicking on circle
				circleDragged = true;
			if(circleDragged == true) //if the circle is being dragged, move it
				c1.move(mouseX, mouseY);

			//if circle and line intersect
		}

		//right click is for line
		else if (mouseButton == RIGHT) { //moves the second point of the line
			l1.setPoint2(mouseX,mouseY);
			System.out.println("was dragged");
		}

		this.redraw();
	}

	public void mouseReleased() {
		/*if(mouseButton == LEFT && circleDragged == true) {
			double endX = Math.random()*500;
			double endY = Math.random()*500;
			double vx = (endX-c1.getX())/10.0;
			double vy = (endY-c1.getY())/10.0;

			circle.setVelocity(vx, vy); //10 = value for time

			for(int i = 0; i<9; i++) {
				circle.act();
				//System.out.println("x is" + vx + " y is " + vy);
			}
		}

		this.redraw(); */
	}

}
