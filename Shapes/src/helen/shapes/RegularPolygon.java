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
	 * constructs default polygon: a triangle starting at 250, 250 and sideLengths = to 100
	 */
	public RegularPolygon() {		
		this(3, 100);
	}

	/**
	 * Constructs a regular polygon with the specified starting point, sides, and sidelengths, and starting point at (250,250)
	 * @param sides number of sides on the shape, must be non-negative
	 * @param length how long each side is
	 * @post array sides is initialised, outCircle and inCircle are created as the circumscribed/inscribed circles
	 */
	public RegularPolygon(int sides, double length) {
		super(250, 250); //centre of window 

		numSides = sides;
		sideLength = length;
		this.sides = new Line[numSides];
		calcSides();
		
		outCircle = new Circle(250-calcR(), 250-calcR(), 2*calcR());
		inCircle = new Circle(250-calcr(), 250-calcr(), 2*calcr());
	}

	/**
	 * draws the polygon
	 * @pre affected by PApplet pre-set conditions
	 * @param drawer PApplet object
	 */
	public void draw(PApplet drawer) {
		super.draw(drawer);

		for(int i = 0; i<numSides; i++) {
			sides[i].draw(drawer);
		}

		/*double initialAngle = (sides-2)*Math.PI; //finding the interior angle in degrees

		for(int i = 0; i<sides; i++) {
			drawer.line((float)x, (float)y, (float)(x+length*Math.cos(angle)), (float)(y+length*Math.sin(angle)));
			x += length*Math.cos(angle);
			y += length*Math.sin(angle);
			angle += initialAngle;
		}*/
	}
	
	/**
	 * draws the circumscribed and inscribed circle
	 * @pre affected by preset PApplet object
	 * @param drawer PApplet object
	 * @post draws the circumscribed circle around the polygon, filled in blue, and the inscribed circle, filled in red and sets their colours
	 */
	public void drawBoundingCircles(PApplet drawer) {
		super.draw(drawer);
		
		outCircle.changeColour(false);
		outCircle.setColour(191, 217, 218); //blue to differentiate outside circle  191, 217, 218
		outCircle.draw(drawer);
		
		inCircle.changeColour(false);
		inCircle.setColour(205, 70, 118); //magenta to differentiate inside circle
		inCircle.draw(drawer);
	}
	
	/**
	 * calculates the sides of the polygon using the angle and starting points
	 * creates new Line representing each side, and adds it to the sides array
	 * @post sides array has new Lines added to it
	 */
	private void calcSides() {
		double startX = x + calcR();
		double startY = y;
		//double angle = Math.toRadians(findAngle());
		double angle = findAngle();

		for(int i = 0; i<numSides; i++) {
			double endX = x + calcR()*Math.cos(angle);
			double endY = y + calcR()*Math.sin(angle);

			Line l1 = new Line(startX, startY, endX, endY);
			/*System.out.println("startX, startY =" + startX + " " + startY);
			System.out.println("endX, endY =" + endX + " " + endY);
			System.out.println("angle" + angle + "degrees" + findAngle());
			System.out.println("cos theta" + Math.cos(angle));
			System.out.println("x is " + x); */
			sides[i] = l1;

			startX = endX;
			startY = endY;

			angle += findAngle();
		}

	}

	/**
	 * finds an angle in radians
	 * @return 2*pi divided by the number of sides
	 */
	public double findAngle() {		
		double angle = Math.PI*2/numSides;
		
		return angle;
	}
	
	/**
	 * calculates the interior angle of the polygon and returns it
	 * @return returns the interior angle in radians
	 */
	public double calcVertexAngle() {
		double angle = (numSides-2)*Math.PI/numSides;
		
		return angle;
	}

	/**
	 * calculate the radius of the circumscribed circle
	 * @return the large radius
	 */
	private double calcR() {		
		double R = sideLength/(2*Math.sin(Math.PI/numSides)); //radius of big circle
		return R;
	}
	/**
	 * calculates the radius of the inscribed circle
	 * @return the small radius
	 */
	private double calcr() {
		double r = sideLength/(2*Math.tan(Math.PI/numSides));
		return r;
	}

	@Override
	/**
	 * returns the area of the shape as a double
	 * @return returns the area of the polygon as a double
	 */
	public double calcArea() {		
		double area = numSides/2*calcR()*calcR()*Math.sin(2*Math.PI/numSides); //formula for area
		
		return area;
	}

	@Override
	/**
	 * returns the perimeter of the shape as a double
	 * @return returns the perimeter as a double
	 */
	public double calcPerimeter() {
		// TODO Auto-generated method stub
		return numSides*sideLength;
	}
	
	/**
	 * accesses the number of sides/numSides field
	 * @return the number of sides as an int
	 */
	public int getNumSides() {
		return numSides;
	}
	
	/**
	 * accesses the sideLength field/finds the length of each side
	 * @return the length of each side as a double
	 */
	public double getSideLength() {
		return sideLength;
	}
	
	/**
	 * accesses private method calcR() to find the large radius
	 * @return returns the large radius as a double
	 */
	public double getR() {
		return calcR();
	}
	
	/**
	 * accesses the private method calcr() to find the small radius
	 * @return returns the small radius as a double
	 */
	public double getr() {
		return calcr();
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
