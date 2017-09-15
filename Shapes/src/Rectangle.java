
public class Rectangle{
	
	private double x, y, width, height;

	//default rect, set all to zero
	public Rectangle() {
	}
	
	
	public Rectangle(double x, double y, double width, double height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public double getPerimeter() {		
		return 2*x + 2*y;
	}
	
	public double getArea() {
		return x*y;
	}

}
