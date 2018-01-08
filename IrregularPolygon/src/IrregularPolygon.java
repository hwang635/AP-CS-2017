import java.awt.geom.*;  // for Point2D.Double
import java.util.ArrayList;      // for ArrayList

import helen.shapes.Shape;
import processing.core.PApplet;	// for Processing

public class IrregularPolygon extends Shape {
	private ArrayList <Point2D.Double> myPolygon;
	private boolean endPolygon;
	private int weight;

	// constructors
	public IrregularPolygon() {  
		super(0,0);
		myPolygon = new ArrayList<Point2D.Double>();
		endPolygon = false;
		weight = 1;
	}

	// public methods
	public void add(Point2D.Double aPoint) {
		myPolygon.add(aPoint);
	}

	//join adjacent points w/ line segments
	//join end + start
	//if right click, the end and start points connect + shape is complete
	public void draw(PApplet marker) {
		marker.strokeWeight(weight);
		
		if(myPolygon.size() == 1) {
			marker.point((float)myPolygon.get(0).getX(),(float)myPolygon.get(0).getY());
		}
		else if (myPolygon.size()>1) {
			for(int i = 0; i<myPolygon.size()-1; i++) {
				double x1 = myPolygon.get(i).getX();
				double y1 = myPolygon.get(i).getY();
				double x2 = myPolygon.get(i+1).getX();
				double y2 = myPolygon.get(i+1).getY();

				marker.line((float)x1, (float)y1, (float)x2, (float)y2);

			}
			if(endPolygon) { //if endPolygon == true
				double x1 = myPolygon.get(0).getX();
				double y1 = myPolygon.get(0).getY();
				double endX = myPolygon.get(myPolygon.size()-1).getX();
				double endY = myPolygon.get(myPolygon.size()-1).getY();

				marker.line((float)x1, (float)y1, (float)endX, (float)endY);
			}
		}

		super.draw(marker);
	}

	public double calcPerimeter() { 
		double perimeter = 0;
		double x1, y1, x2, y2;
		for(int i = 0; i<myPolygon.size()-1; i++) {
			x1 = myPolygon.get(i).getX();
			y1 = myPolygon.get(i).getY();
			x2 = myPolygon.get(i+1).getX();
			y2 = myPolygon.get(i+1).getY();

			perimeter += Math.pow((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2), 0.5);
		}

		//endpoint - start point distance
		x1 = myPolygon.get(0).getX();
		y1 = myPolygon.get(0).getY();
		x2 = myPolygon.get(myPolygon.size()-1).getX();
		y2= myPolygon.get(myPolygon.size()-1).getY();

		perimeter += Math.pow((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2), 0.5);

		return perimeter;
	}

	public double calcArea() {  
		double area = 0;
		int length = myPolygon.size();
		if(length<3)
			return area;
		else {
			for(int i = 0; i<length-1; i++) {
				area += myPolygon.get(i).getX()*myPolygon.get(i+1).getY();
			}
			area += myPolygon.get(length-1).getX()*myPolygon.get(0).getY();

			for(int i = 0; i<length-1; i++) {
				area -= myPolygon.get(i).getY()*myPolygon.get(i+1).getX();
			}
			area -= myPolygon.get(length-1).getY()*myPolygon.get(0).getX();

			return Math.abs(area/2);
		}
	}

	//choice methods
	@Override
	public boolean isPointInside(double x, double y) {
		for(Point2D.Double p: myPolygon) {
			//if()
		}
		return false;
	}

	//scales the shape according to the factor entered
	//the first point in the arraylist stays the same, is a reference point
	public void scale(double factor) {
		double refX = myPolygon.get(0).getX(); //reference x and y points that stay the same
		double refY = myPolygon.get(0).getY();

		for(Point2D.Double p: myPolygon) {
			double newX = refX + (p.getX()-refX)*factor;
			double newY = refY + (p.getY()-refY)*factor;

			p.setLocation(newX, newY);
		}
	}

	public void setEnd(boolean endPolygon) {
		this.endPolygon = endPolygon;
	}
	
	public void setStrokeWeight(int weight) {
		this.weight = weight;
		System.out.println("weight = " + weight);
	}

	@Override
	public void changeColour(boolean isGrey) {
	}
}
