package evan.shapeDemo;

import helen.shapes.Shape;
import processing.core.PApplet;
public class PhysicsShape {

	private Shape boundingShape;
	private double vX, vY;
	private static final double GRAVITY = 9.81 / 60.0;
	private static final double HORIZONTAL_ACCEL = 9.0 / 60.0;
	
	
	public PhysicsShape(Shape bS) {
		vX = 0;
		vY = 0;
		boundingShape = bS;
		boundingShape.setColour(0, 0, 0);
		boundingShape.setStrokeWeight(3);
	}
	
	public void draw(PApplet drawer) {
		boundingShape.draw(drawer);
	}
	
	public Shape getBoundingShape() {
		return boundingShape;
	}
	
	public void setVelocity(double a, double b) {
		vX = a;
		vY = b;
	}
	
	public void act(DrawingSurface drawer) {
		
		if (getBottomY() <= 369) {//if it's in mid-air
			vY += GRAVITY;
		}
		else {//when it's bouncing, the direction of the vertical velocity is inverted.
			vY = -vY * 0.7;
			
		}
		if ((boundingShape.getY() <= 0)) {
			boundingShape.moveTo(boundingShape.getX(), 0);
			vY = -vY;
		}
		if ((getCenterX() <= 0)) {
			vX= -vX * 0.7;
			boundingShape.moveTo(0, boundingShape.getY());
		}
		if ((getCenterX() + (boundingShape.calcPerimeter() / (2 * Math.PI)) >= 400)) {
			vX= -vX * 0.7;
			boundingShape.moveTo(400 -(boundingShape.calcPerimeter() / (2 * Math.PI)), boundingShape.getY());
		}
		if (Math.getExponent(vY) <= -100) {//stops repetitive micro-bouncing to prevent overflow
			vY = 0;
		}
		if (Math.getExponent(vX) <= -100) {
			vX = 0;
		}
		
	double currentX = getCenterX();
		//double horizAccel = Math.sqrt( Math.pow(getX() - drawer.mouseX, 2) + Math.pow(g, b) )
		if (currentX > drawer.mouseX && (getCenterX() >= 0)) {
			vX -= HORIZONTAL_ACCEL;
		}
		else if (currentX < drawer.mouseX) {
			vX += HORIZONTAL_ACCEL;
		}
		else if (Double.compare(currentX, drawer.mouseX) == 0) {
			vX = 0;
		}
		boundingShape.moveBy(vX, vY);
		

	}
	
	public boolean isColliding() {
		
		return false;
	}
	
	public double[] quadraticFormula(double a, double b, double c) { //needed to calculate the width and height of a rectangle PhysicsShape
		//Only works if the equation passed in has two real roots.
		double[] root = new double[2];
		root[0] = (-b + Math.sqrt((b * b) - (4 * a * c))) / (2 * a);
		root[1] = (-b - Math.sqrt((b * b) - (4 * a * c))) / (2 * a);
		return root;
	}
	
	public boolean checkBottomBounds() {
		return (getBottomY() <= 369);
	}
	
	public boolean checkTopBounds() {
		return (boundingShape.getY() >= 0);
	}
	
	public double getCenterX() {
			return boundingShape.getX();
	}
	
	public double getCenterY() {
		return boundingShape.getY() + (boundingShape.calcPerimeter() / ( 2 * Math.PI));
	}
	
	public double getBottomY() {
		if(boundingShape.getClass().toString().equals("class helen.shapes.Circle")) {
		return (boundingShape.calcPerimeter() / ( 2 * Math.PI)) + boundingShape.getY();
		}
		else return (boundingShape.getY() + Math.sqrt(boundingShape.calcArea()));
	}
	

	
	public double getvY() {
		return vY;
	}
	
	public double getvX() {
		return vX;
	}
	
	public void jump() {
		if (!checkBottomBounds()) {
			vY += 10;
		}
	}
	
}
