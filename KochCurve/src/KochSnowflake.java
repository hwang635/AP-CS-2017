import processing.core.PApplet;


/**
  @(#)KochCurve.java


  @author
  @version
 */
public class KochSnowflake {
	
	private int level;
	private int length;

	// TO DO

	public KochSnowflake(int level, int length) {
		this.level = level;
		this.length = length;
	}

	public void draw(PApplet marker) {
		float rad60 = (float) (Math.PI/3);

		drawKochCurve(marker, this.level, 3*rad60, 50+length, 100, this.length);
		drawKochCurve(marker, this.level, rad60, 50, 100, this.length);
		drawKochCurve(marker, this.level, -rad60, (float)(50+length*Math.cos(rad60)), (float)(100-Math.sin(rad60)*length), this.length);
	}

	private void drawKochCurve(PApplet marker, int level, float angle, float x, float y, float length) {
		if(level < 1) {
			float x2 = (float) (x + length*Math.cos(angle));
			float y2 = (float) (y - Math.sin(angle)*length);
			marker.line(x, y, x2, y2);
		}
		else {
			float rad60 = (float) (Math.PI/3);
			
			//draw line 1/3 of length
			drawKochCurve(marker, level-1, angle, x, y, length/3);
			
			x = (float) (x + length/3*Math.cos(angle));
			y = (float) (y - length/3*Math.sin(angle));
			
			//draw k-1 level curve, 60 degrees from where left off
			drawKochCurve(marker, level-1, angle+rad60, x, y, length/3);
			
			x = (float) (x + length/3*Math.cos(angle+rad60));
			y = (float) (y - length/3*Math.sin(angle+rad60));
			
			//draw k-1 curve, -60 degrees from where left off
			drawKochCurve(marker, level-1, angle-rad60, x, y, length/3);
			
			x = (float) (x + length/3*(Math.cos(angle-rad60)));
			y = (float) (y - length/3*Math.sin(angle-rad60));
			
			//draw k-1 curve, where previous left off
			drawKochCurve(marker, level-1, angle, x, y, length/3);
		}
	}

}
