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

	private void drawKochCurve(PApplet marker, int level, int angle, float x, float y, float length) {
		if(level < 1) {
			marker.line(x, y, x+length, y + (float) (Math.sin(angle)*y));
		}
		else {
			drawKochCurve(marker, level-1, angle, x, y, length/3);

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
