import processing.core.PApplet;

public class DrawingSurface extends PApplet{
	
	public Rectangle rect1, rect2, rect3;
	public Circle circle1, circle2;

	public DrawingSurface() {
		rect1 = new Rectangle();
		rect2 = new Rectangle(0, 80, 400, 160);
		rect3 = new Rectangle(100, -100, 20, -300);
		
		circle1 = new Circle();
		circle2 = new Circle(50, 50, 50);
		
		this.test();
	}
	
	public void draw() {
		rect1.draw(this);
		rect2.draw(this);
		rect3.draw(this);
		
		circle1.draw(this);
		circle2.draw(this);
	}
	
	public void test() {
		rect3.getPerimeter();
		rect3.getArea();
		rect3.isPointInside(0, 100);
		rect3.isPointInside(10, 5);
		rect3.isSquare();
		rect3.scaledShape(3);
		
		/*circle1.getPerimeter();
		circle1.getArea();
		circle1.isPointInside(0, 100);
		circle1.isPointInside(10, 5);
		circle1.isLessThan(50, 50);
		circle1.scaledShape(2); */
		
		/*circle2.getPerimeter();
		circle2.getArea();
		circle2.isPointInside(0, 100);
		circle2.isPointInside(10, 5);
		//circle2.isLessThan(50, 50);
		//circle2.scaledShape(2); */
	}
}
