import kush.shapes.Circle;
import kush.shapes.Line;
import kush.shapes.Rectangle;
import processing.core.PApplet;

public class DrawingCopy extends PApplet{

	private PhysicsShape circle;
	//private PhysicsShape line; //ended up not using line for any movement things
	private PhysicsShape rectangle;
	private Circle c1;
	//private Line l1;
	private Rectangle r1;

	private boolean circleDragged, circleRight;
	private boolean rectDragged, rectRight;

	public DrawingCopy() {
		c1 = new Circle(280, 200, 50);
		c1.setFill(50, 170,  180);

		//l1 = new Line(10, 10, 50, 50);
		//line = new PhysicsShape(l1);
		
		r1 = new Rectangle(180, 176, 30, 49);
		r1.setFill(158, 20, 80);

		circleDragged = false;
	}

	public void draw() {
		background(255);

		circle = new PhysicsShape(c1);
		rectangle = new PhysicsShape(r1);
		//l1.borderThickness(5);
		//l1.draw(this);
		//line = new PhysicsShape(l1);

		circle.draw(this);
		//line.draw(this);
		rectangle.draw(this);

		if(circleDragged == true) { //circle moves downwards
			if(circle.getCoordinate(2) <450) {
				if(circleRight==true)
					circle.setVelocity(1.5, circle.getGravity());
				else
					circle.setVelocity(-1.5, circle.getGravity());

				circle.act();
				System.out.println("y is" + circle.getCoordinate(2));
			}
			else {
				circle.stop();
				circle.act();
			}
		}
		
		if(rectDragged == true) { //rectangle goes upwards
			if(rectangle.getCoordinate(2) > 5) {
				if(rectRight==true)
					rectangle.setVelocity(1.5, -rectangle.getGravity());
				else
					rectangle.setVelocity(-1.5, -rectangle.getGravity());

				rectangle.act();
				System.out.println("y is" + rectangle.getCoordinate(2));
			}
			else {
				rectangle.stop();
				rectangle.act();
			}
		}
	}


	public void mousePressed() {
		/*if(mouseButton == LEFT) {
			System.out.println("left");
		}

		if (mouseButton == RIGHT) {
			//l1 = new Line(mouseX,mouseY,mouseX,mouseY);
			System.out.println("right");
			this.redraw();
		} */
	}

	public void mouseDragged() {
		//left click is for circle
		if(mouseButton == LEFT) {
			if(c1.isPointInside(mouseX, mouseY)) {//makes sure that was clicking on circle
				circleDragged = true;
				rectDragged = false;
			}
			if(circleDragged == true) {//if the circle is being dragged, move it
				if(mouseX>c1.getX())
					circleRight = true;
				else
					circleRight = false;

				c1.move(mouseX, mouseY);
			}
		}

		//right click is for rectangle
		else if (mouseButton == RIGHT) {
			//l1.setPoint2(mouseX,mouseY);
			if(r1.isPointInside(mouseX, mouseY)) {
				rectDragged = true;
				circleDragged = false;
			}
			if(rectDragged == true) {
				if(mouseX>r1.getX())
					rectRight = true;
				else
					rectRight = false;
				
				r1.move(mouseX, mouseY);
			}
				
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
