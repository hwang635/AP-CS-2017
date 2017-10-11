package helen.shapes;

import processing.core.PApplet;


/**
 * models a regular polygon (polygon with congruent angles and sides)
 * @author Helen Wang
 * @version 10.11.17
 *
 */
public class RegularPolygon extends Shape {
	
	private int numSides;
	private double sideLength;
	private Circle outCircle, inCircle; //circumscribed and inscribed circle
	private Line[] sides;

	/**
	 * constructs default polygon with x, y, sides, and length all equal to zero
	 */
	public RegularPolygon() {
		super(0,0);
	}
	
	/**
	 * Constructs a regular polygon with the specified starting point, sides, and sidelengths
	 * @param x X-coordinate of the starting vertex
	 * @param y Y-coordinate of the starting vertex
	 * @param sides number of sides on the shape
	 * @param length how long each side is
	 */
	public RegularPolygon(int sides, double length) {
		super(250, 250); //centre of window 
		
		numSides = sides;
		sideLength = length;
	}
	
	public void draw(PApplet drawer) {
		super.draw(drawer);
		
		/*double initialAngle = (sides-2)*Math.PI; //finding the interior angle in degrees
		double angle = initialAngle; //to use in loop
		
		for(int i = 0; i<sides; i++) {
			drawer.line((float)x, (float)y, (float)(x+length*Math.cos(angle)), (float)(y+length*Math.sin(angle)));
			x += length*Math.cos(angle);
			y += length*Math.sin(angle);
			angle += initialAngle;
		}*/
	}
	
	private void calcr() {
		double angle = (numSides-2)*180;
		
		double R = sideLength/(2*Math.sin(Math.PI/numSides)); //radius of big circle
		double r = sideLength/(2*Math.tan(Math.PI/numSides));
	}

	@Override
	/**
	 * returns the area of the shape as a double
	 */
	public double calcArea() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	/**
	 * returns the perimeter of the shape as a double
	 */
	public double calcPerimeter() {
		// TODO Auto-generated method stub
		return numSides*sideLength;
	}

	@Override
	public boolean isPointInside(double x, double y) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void changeColour(boolean isGrey) {
		// TODO Auto-generated method stub
		
	}

}
