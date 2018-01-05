import java.awt.geom.*;  // for Point2D.Double
import java.util.ArrayList;      // for ArrayList

import helen.shapes.Shape;
import processing.core.PApplet;	// for Processing

public class IrregularPolygon extends Shape {
	private ArrayList <Point2D.Double> myPolygon;

	// constructors
	public IrregularPolygon() {  
		super(0,0);
	}

	// public methods
	public void add(Point2D.Double aPoint) {
		myPolygon.add(aPoint);
	}

	public void draw(PApplet marker) {  
		//for(Point2D.Double x: myPolygon)
	}

	public double calcPerimeter() { 
		for(int i = 0; i<myPolygon.size(); i++) {
			//int distance = 
			
		}
		
		return 0;
	}

	public double calcArea() {  
		return 0;  
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
