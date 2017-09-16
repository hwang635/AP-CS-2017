import processing.core.PApplet;

public class Circle {

	private double x, y, radius;
	
	//sets to zero
	public Circle() {
	}
	
	//sets to entered arguments
	public Circle(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	
	public double getPerimeter() {		
		return 2*Math.PI*radius;
	}
	
	public double getArea() {
		return 2*Math.PI*radius*radius;
	}
	
	//checks if entered point is inside the circle
	public boolean isPointInside() {
		
		return false;
	}
	
	public void draw(PApplet marker) {
		marker.ellipse((float)x, (float)y, (float)radius, (float)radius);
	}
	
	//additional method #1
	//checks whether the area/perimeter are smaller/larger than entered area/perimeter
	public void isLessThan(double area, double perimeter) {
		if (area>this.getArea())
			System.out.println("The circle has smaller area");
		else if (area<this.getArea())
			System.out.println("The circle has greater area");
		else
			System.out.println("The cirlce has the same area");
		
		if(perimeter>this.getPerimeter())
			System.out.println("The circle has smaller perimeter");
		else if(perimeter<this.getPerimeter())
			System.out.println("The circle has greater perimeter");
		else
			System.out.println("The circle has the same perimeter");
	}
	
	//additional method #2, same as rect
	//new circle at same (x, y), but 1/n of the radius
	public Circle scaledShape(double n) {
		double newRadius = radius*1.0/n;
		
		return new Circle(x, y, newRadius);
	}
	
}
