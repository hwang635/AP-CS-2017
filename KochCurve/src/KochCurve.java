import processing.core.PApplet;


/**
  @(#)KochCurve.java


  @author
  @version
 */
public class KochCurve {
	
	private int level;
	private int length;

	// TO DO

	public KochCurve(int level, int length) {
		this.level = level;
		this.length = length;
	}

	public void draw(PApplet marker) {
		drawKochCurve(marker, this.level, 0, 50, 50, this.length);
	}

	private void drawKochCurve(PApplet marker, int level, float angle, float x, float y, float length) {
		if(level < 1) {
			marker.line(x, y, (float) (x+length*Math.cos(angle)), y - (float) (Math.sin(angle)*length));
			System.out.println("x = " + x + " x2 = "  + (x+length*Math.cos(angle))); 
			System.out.println("y = " + y + " y2 = "  + (y - (Math.sin(angle)*length))); 

		}
		else {
			float rad60 = (float) (Math.PI/3);
			float sin60 = (float) Math.sin(rad60);
			float cos60 = (float) Math.cos(rad60);

			drawKochCurve(marker, level-1, angle, x, y, length/3);
			
			drawKochCurve(marker, level-1, angle+rad60, x+length/3, y, length/3);
			drawKochCurve(marker, level-1, angle-rad60, x+length/3+length/3*cos60, y-length/3*sin60, length/3);
			drawKochCurve(marker, level-1, angle, x+length/3+2*length/3*cos60, y, length/3);
		}
		
		/*
	if level < 1 then
  	Draw a straight line of the current length
	else
  	Draw a k-1 level Koch curve of 1/3 the current length

  	Starting where the previous left off, draw a k-1 level Koch curve of 1/3 the current length, at an angle of 60 degrees with respect to the current angle

  	Starting where the previous left off, draw a k-1 level Koch curve of 1/3 the current length, at an angle of -60 degrees with respect to the current angle

  	Starting where the previous left off, draw a k-1 level Koch curve of 1/3 the current length
		 */
		
		// TO DO
	}

}
