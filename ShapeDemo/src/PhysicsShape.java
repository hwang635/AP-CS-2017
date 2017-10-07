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

	//constructors
	public PhysicsShape(Shape boundingShape) {
		vx = 0;
		vy = 0;

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
	}

	//stops, sets all velocity to zero
	public void stop() {
		vx = 0;
		vy = 0;
	}

	//for circle movement
	public void act() {
		//boundingShape.moveBy(boundingShape.getX(), boundingShape.getY());

		if(bound instanceof Shapes2D) {
			Shapes2D bound2d = (Shapes2D) bound;
			//bound2d.moveBy(vx, vy);

			double ax = vx/-10.0;
			double ay = vy/-10.0;
			
			while(Math.abs(vx) > 0.5 || Math.abs(vy) > 0.5) {
				bound2d.move(bound2d.getX()+vx, bound2d.getY()+vy);
				vx += ax;
				vy += ay;
				System.out.println("vx is " + vx + " vy is " + vy);
			}


			/*try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} */

		}
	}

}
