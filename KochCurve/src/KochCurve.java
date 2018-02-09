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
		//drawKochCurve(marker, level, 0, length);
	}

	private void drawKochCurve(PApplet marker, int levelC, int x, int y, int angle) {
		if(level < 1) {
			marker.line(x, y, x, y + length);
		}
		else {
			//drawKochCurve(marker, x, y, levelC-1, 0, length/3);
			//drawKochCurve(marker, levelC-1, 60, length/3);
			//drawKochCurve(marker, levelC-1, -60, length/3);
			//drawKochCurve(marker, levelC-1, angle, length/3);

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
