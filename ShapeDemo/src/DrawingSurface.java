import kush.shapes.Circle;
import kush.shapes.Line;
import kush.shapes.Rectangle;
import processing.core.PApplet;

public class DrawingSurface extends PApplet{

	private PhysicsShape circle;
	//private PhysicsShape line; //ended up not using line for any movement things
	private PhysicsShape rectangle;
	private PhysicsShape boundary, secondBound;
	private Circle c1;
	//private Line l1;
	private Rectangle r1;
	private Rectangle r2; //the purple box
	private Rectangle r3; //purple line on the bottom
	

	private boolean circleDragged, circleRight;
	private boolean rectDragged, rectRight;


	public DrawingSurface() {
		c1 = new Circle(280, 200, 50);
		c1.setFill(50, 170,  180);

		//l1 = new Line(10, 10, 50, 50);
		//line = new PhysicsShape(l1);

		r1 = new Rectangle(180, 176, 30, 49);
		r1.setFill(158, 30, 80);
		r2 = new Rectangle(150, 150, 184, 100);
		r2.setFill(128, 110, 128);
		boundary = new PhysicsShape(r2);
		r3 = new Rectangle(180, 400, 124, 5);
		r3.setFill(128, 110, 128);
		secondBound = new PhysicsShape(r3);

		circleDragged = false;
	}

	public void draw() {
		background(255);

		circle = new PhysicsShape(c1);
		rectangle = new PhysicsShape(r1);
		//l1.borderThickness(5);
		//l1.draw(this);
		//line = new PhysicsShape(l1);

		boundary.draw(this);
		secondBound.draw(this);
		circle.draw(this);
		//line.draw(this);
		rectangle.draw(this);

		if(circleDragged == true) { //circle moves downwards
			if(circle.getCoordinate(2)<450 && circle.getCoordinate(1) > 30 && circle.getCoordinate(1) <470) {
				if(circleRight==true)
					circle.setVelocity(1.5, circle.getGravity()-circle.getCoordinate(2)/46);
				else
					circle.setVelocity(-1.5, circle.getGravity()-circle.getCoordinate(2)/46);

				circle.act();
			}
			else if(circle.getCoordinate(2)<450) {
				circle.setVelocity(0, circle.getGravity()-circle.getCoordinate(2)/46);
				circle.act();
			}
			else {
				circle.stop();
				circle.act();
				circleDragged = false;
			}
		}

		if(rectDragged == true) { //rectangle goes upwards
			if(rectangle.getCoordinate(2) > 1 && rectangle.getCoordinate(1)>1 && rectangle.getCoordinate(1)<469) {
				if(rectRight==true)
					rectangle.setVelocity(1.5, -rectangle.getGravity()+(500-rectangle.getCoordinate(2))/52);
				else
					rectangle.setVelocity(-1.5, -rectangle.getGravity()+(500-rectangle.getCoordinate(2))/52);

				rectangle.act();
			}
			else if(rectangle.getCoordinate(2)>1) {
				rectangle.setVelocity(0, -rectangle.getGravity()+(500-rectangle.getCoordinate(2))/52);
				rectangle.act();
			}
			else {
				rectangle.stop();
				rectangle.act();
			}
		}

		double xCheck = Math.pow(circle.getCoordinate(1)-rectangle.getCoordinate(1), 2.0);
		double yCheck = Math.pow(circle.getCoordinate(2)-rectangle.getCoordinate(2), 2.0);

		if(xCheck + yCheck <= 2500) {//checks if rectangle and circle intersect
			c1.setFill(18, 230, 128);
			r1.setFill(150, 120, 180);
		}
		else {
			c1.setFill(50, 170, 180);
			r1.setFill(158, 30, 80);
		}
		
		if(circle.getCoordinate(1)>=180 && circle.getCoordinate(1)<=304) {
			if(circle.getCoordinate(2)>=400 && circle.getCoordinate(2)>=405) {
				c1.move(280, 200);
				circleDragged = false;
				circle.act();
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
		} */

		if(circleDragged == true) { //tells which direction the obj
			if(mouseX>c1.getX())
				circleRight = true;
			else
				circleRight = false;
		}

		if(rectDragged == true) {
			if(mouseX>r1.getX())
				rectRight = true;
			else
				rectRight = false;
		}
		this.redraw();
	}

}
