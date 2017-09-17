import processing.core.PApplet;

public class Circle {

	private double x, y, radius;
	private double area, perimeter;
	public boolean isGrey;
	private int r, g, b;

	//sets to zero
	public Circle() {
	}

	//sets to entered arguments
	public Circle(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		isGrey = true;

		this.area = this.getArea();
		this.perimeter = this.getPerimeter();
	}

	public double getPerimeter() {
		double p = Math.abs(2*Math.PI*radius); //abs in case negative arg
		//pln to check
		System.out.println("Perimeter is " + p); 

		return p;
	}

	public double getArea() {
		double a = Math.abs(2*Math.PI*radius*radius); //abs in case neg arg
		//pln to check
		System.out.println("Area is " + a);

		return a;
	}

	//checks if entered point is inside the circle
	public boolean isPointInside(double x, double y) {

		//circle for equation x^2 + y^2 = r^2, split into 2 local var for readability
		double xPart = (x-this.x)*(x-this.x); //x^2
		double yPart = (y-this.y)*(y-this.y); //y^2

		if((xPart + yPart) <= (radius*radius)) {
			System.out.println("The point is inside");
			return true;
		}
		else {
			System.out.println("The point is outside");
			return false;
		}
	}

	public void draw(PApplet marker) {		
		if(isGrey == true)
			marker.fill(g);
		else
			marker.fill(r, b, g);

		marker.ellipse((float)x, (float)y, (float)radius, (float)radius);
		marker.noFill();
	}

	//additional method #1
	//checks whether the area/perimeter are smaller/larger than entered area/perimeter
	public void isLessThan(double area, double perimeter) {
		if (area>this.area)
			System.out.println("The circle has smaller area");
		else if (area<this.area)
			System.out.println("The circle has greater area");
		else
			System.out.println("The cirlce has the same area");

		if(perimeter>this.perimeter)
			System.out.println("The circle has smaller perimeter");
		else if(perimeter<this.perimeter)
			System.out.println("The circle has greater perimeter");
		else
			System.out.println("The circle has the same perimeter");
	}

	//additional method #2
	//moves the shape by the entered ints
	public void translate(double shiftX, double shiftY) {
		this.x = this.x + shiftX;
		this.y = this.y + shiftY;
	}

	//additional method #3
	//sets fill, if isGreyScale == true random greyscale colour, else = an actual rbg colour
	public void changeColour(boolean isGrey) {
		this.isGrey = isGrey;

		//random three values, only g is used if grayscale
		this.r = (int) (Math.random()*256);
		this.g = (int) (Math.random()*256);
		this.b = (int) (Math.random()*256);
	}

}
