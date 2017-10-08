import java.util.concurrent.TimeUnit;

import kush.shapes.Circle;
import kush.shapes.Shape;
import kush.shapes.Shapes1D;
import kush.shapes.Shapes2D;
import processing.core.PApplet;

public class PhysicsShape {

	//fields
	private Shape bound;

	private double vx, vy;
	private double gravity;

	//constructors
	public PhysicsShape(Shape boundingShape) {
		vx = 0;
		vy = 0;
		gravity = 9.81;

		this.bound = boundingShape;
	}

	//methods
	public void draw(PApplet drawer) {
		if(bound instanceof Shapes2D) {
			Shapes2D bound2d = (Shapes2D)bound;
			bound2d.draw(drawer);
		}

		else if(bound instanceof Shapes1D) {
			Shapes1D bound1d = (Shapes1D)bound;
			bound1d.draw(drawer);
		}
	}

	public Shape getBoundingShape() {
		return bound;
	}


	//circle will return to starting position if dragged
	public void returnToStart (Circle circle, int startX, int startY) {
		int x = (int) circle.getX();
		int y = (int) circle.getY();	

		//x is being pulled to the right;
		if(x < startX) {

		}
		//x is being pulled to the left
		if(x>startX);
		//y is being pulled down
		if(y>startY);
		//y is being pulled up
		if(y<startY);

	}

	//for line acc = g sin(tan-1 y/x)
	//for normal velocity for dragged circle = v1 = 4, a = -0.8
	public void setVelocity(double vx, double vy) {
		this.vx = vx;
		this.vy = vy;

		/*double endX = Math.random()*500;
		double endY = Math.random()*500;

		if(bound instanceof Shapes2D) {
			Shapes2D bound2d = (Shapes2D)bound;
			double deltaX = endX-bound2d.getX();
			double deltaY = endY-bound2d.getY();

			this.vx = deltaX/20.0;
			this.vy = deltaY/20.0;
		} */
	}

	public double getVx() {
		return vx;
	}

	public double getVy() {	
		return vy ;
	}
	
	public double getGravity() {
		return gravity;
	}

	//stops, sets all velocity to zero
	public void stop() {
		vx = 0;
		vy = 0;
	}

	//return x/y coordinate depending on int entered in
	public double getCoordinate(int choice) {
		Shapes2D bound2d = (Shapes2D) bound;

		if(choice == 1)
			return bound2d.getX();
		else if(choice == 2)
			return bound2d.getY();
		else
			return 0;
	}
	//for circle movement
	public void act() {
		if(bound instanceof Shapes2D) {
			Shapes2D bound2d = (Shapes2D) bound;
			bound2d.moveBy(vx, vy);
			if(gravity > 0.5) {
				gravity -= 0.5;
			}
			System.out.println("vy is " + vy + "gravity is " + gravity);
		}

		/*if(bound instanceof Shapes2D) {
			Shapes2D bound2d = (Shapes2D) bound;
			//bound2d.moveBy(vx, vy);

			double ax = vx/-20.0;
			double ay = vy/-20.0;

			while(Math.abs(vx) > 0.5 || Math.abs(vy) > 0.5) {
				bound2d.moveBy(bound2d.getX()+vx, bound2d.getY()+vy);
				vx -= ax;
				vy += ay;
				System.out.println("vx is " + vx + " vy is " + vy);
			} */

	}
}
