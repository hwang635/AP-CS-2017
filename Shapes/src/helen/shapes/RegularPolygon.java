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
	 * Constructs a regular polygon with the specified starting point, sides, and sidelengths, and starting point at (250,250)
	 * @param x X-coordinate of the starting vertex
	 * @param y Y-coordinate of the starting vertex
	 * @param sides number of sides on the shape, must be non-negative
	 * @param length how long each side is
	 * @post array sides is initialised, 
	 */
	public RegularPolygon(int sides, double length) {
		super(250, 250); //centre of window 

		numSides = sides;
		sideLength = length;

		this.sides = new Line[numSides];
		calcSides();
	}

	/**
	 * draws the polygon
	 * @param drawer PApplet object
	 * @pre affected by PApplet pre-set conditions
	 */
	public void draw(PApplet drawer) {
		super.draw(drawer);

		for(int i = 0; i<numSides; i++) {
			sides[i].draw(drawer);
		}

		/*double initialAngle = (sides-2)*Math.PI; //finding the interior angle in degrees
		double angle = initialAngle; //to use in loop

		for(int i = 0; i<sides; i++) {
			drawer.line((float)x, (float)y, (float)(x+length*Math.cos(angle)), (float)(y+length*Math.sin(angle)));
			x += length*Math.cos(angle);
			y += length*Math.sin(angle);
			angle += initialAngle;
		}*/
	}
	
	/**
	 * calculates the sides of the polygon using the angle and starting points
	 * creates new Line representing each side, and adds it to the sides array
	 * @post sides array has new Lines added to it
	 */
	public void calcSides() {
		double startX = x + calcR();
		double startY = y;
		//double angle = Math.toRadians(findAngle());
		double angle = findAngle();

		for(int i = 0; i<numSides; i++) {
			double endX = x + calcR()*Math.cos(angle);
			double endY = y + calcR()*Math.sin(angle);

			Line l1 = new Line(startX, startY, endX, endY);
			System.out.println("startX, startY =" + startX + " " + startY);
			System.out.println("endX, endY =" + endX + " " + endY);
			System.out.println("angle" + angle + "degrees" + findAngle());
			System.out.println("cos theta" + Math.cos(angle));
			System.out.println("x is " + x);
			sides[i] = l1;

			startX = endX;
			startY = endY;

			angle += findAngle();
		}

	}
	/**
	 * calculates the full angle of the polygon and returns individual interior angle value
	 * @return returns the angle in degrees
	 */
	public double findAngleDegrees() {
		double angle = (numSides-2)*180;
		angle = angle/numSides;

		return angle;
	}

	/**
	 * finds the angle in radians
	 * @return the interior angle of the polygon in raidnas
	 */
	public double findAngle() {
		//double angle = (numSides-2)*Math.PI/numSides;
		
		double angle = Math.PI*2/numSides;
		
		return angle;
	}

	/**
	 * calculate the radius of the circumscribed circle
	 * @return the large radius
	 */
	public double calcR() {		
		double R = sideLength/(2*Math.sin(Math.PI/numSides)); //radius of big circle
		return R;
	}
	/**
	 * calculates the radius of the inscribed circle
	 * @return the small radius
	 */
	public double calcr() {
		double r = sideLength/(2*Math.tan(Math.PI/numSides));
		return r;
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
