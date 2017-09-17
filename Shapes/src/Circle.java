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
		double perimeter = Math.abs(2*Math.PI*radius); //abs in case negative arg
		
		//pln to check
		System.out.println("Perimeter is " + perimeter); 
		
		return perimeter;
	}
	
	public double getArea() {
		double area = Math.abs(2*Math.PI*radius*radius); //abs in case neg arg
		
		//pln to check
		System.out.println("Area is " + area);
		
		return area;
	}
	
	//checks if entered point is inside the circle
	public boolean isPointInside(double x, double y) {
		
		System.out.println("isPointInside");
		return false;
	}
	
	public void draw(PApplet marker) {
		marker.ellipse((float)x, (float)y, (float)radius, (float)radius);
	}
	
	//additional method #1
	//checks whether the area/perimeter are smaller/larger than entered area/perimeter
	public void isLessThan(double area, double perimeter) {
		double a = this.getArea();
		double p = this.getPerimeter();
		if (area>a)
			System.out.println("The circle has smaller area");
		else if (area<a)
			System.out.println("The circle has greater area");
		else
			System.out.println("The cirlce has the same area");
		
		if(perimeter>p)
			System.out.println("The circle has smaller perimeter");
		else if(perimeter<p)
			System.out.println("The circle has greater perimeter");
		else
			System.out.println("The circle has the same perimeter");
	}
	
	//additional method #2, same as rect
	//new circle at same (x, y), but 1/n of the radius
	public Circle scaledShape(double n) {
		double newRadius = radius*1.0/n;
		Circle scaledCircle = new Circle(x, y, radius);
		
		System.out.println("check, inside scaled shape for circle");
		
		return scaledCircle;
	}
	
}
