package helen.testers;
import helen.shapes.Circle;
import helen.shapes.Rectangle;
import helen.shapes.RegularPolygon;
import processing.core.PApplet;

public class DrawingSurface extends PApplet{

	//public Rectangle rect1, rect2, rect3, rectTest;
	//public Circle circle1, circle2;
	
	public RegularPolygon p0, p1, p2, p3, p4;

	public DrawingSurface() {
		/*rect1 = new Rectangle();
		rect2 = new Rectangle(0, 80, 400, 160);
		rect3 = new Rectangle(100, -100, 20, -300);
		
		rectTest = new Rectangle(200, 100, 100, 100);

		circle1 = new Circle();
		circle2 = new Circle(50, 50, 50); */
		
		p0 = new RegularPolygon();
		p1 = new RegularPolygon(4, 100);
		p2 = new RegularPolygon(8, 5.75);
		p3 = new RegularPolygon(19, 2);
		p4 = new RegularPolygon(91, 0.5);
		
	}

	public void draw() {
		/*rect1.draw(this);
		//rect2.draw(this);
		rect3.draw(this);
		rectTest.draw(this);

		circle1.draw(this);
		circle2.draw(this); */

		p1.drawBoundingCircles(this);
		p1.draw(this);
		//p1.drawBoundingCircles(this);
		//p1.draw(this);
		//p2.draw(this);
		//p3.draw(this);
		//p4.draw(this);
		
		if(keyPressed == true) { //for testing purposes
			
			System.out.println(p4.calcPerimeter());
			System.out.println(p4.calcArea());
			System.out.println(p4.getR());
			System.out.println(p4.getr());
			
			/*rect3.calcPerimeter();
			rect3.calcArea();
			rect3.isPointInside(0, 100);
			rect3.isPointInside(10, 5);
			rect3.isSquare();
			rect3.moveBy(50, 50);
			rect3.changeColour(false);
			
			rectTest.calcPerimeter();
			rectTest.calcArea();
			rectTest.isPointInside(100, 200);
			rectTest.isPointInside(10, 5);
			rectTest.isSquare();
			rectTest.moveBy(50, 50);
			rectTest.changeColour(false);
			

			circle2.calcPerimeter();
			circle2.calcArea();
			circle2.isPointInside(0, 100);
			circle2.isPointInside(80, 75);
			circle2.isLessThan(50, 50);
			circle2.moveBy(20, -2);
			circle2.changeColour(true); */

			keyPressed = false;
		}
	}
}
