import processing.core.PApplet;

public class PythagorasTree {
	
	private int level;
	private int length;

	// TO DO

	public PythagorasTree(int level, int length) {
		this.level = level;
		this.length = length;
	}

	public void draw(PApplet marker) {
		drawTree(marker, this.level, 0, 50, 100, this.length);
	}

	private void drawTree(PApplet marker, int level, float angle, float x, float y, float length) {
		if(level < 1) {
			float x2 = (float) (x + length*Math.cos(angle));
			float y2 = (float) (y - Math.sin(angle)*length);
			marker.line(x, y, x2, y2);
			//System.out.println("x = " + x + " x2 = "  + (x+length*Math.cos(angle))); 
			//System.out.println("y = " + y + " y2 = "  + (y - (Math.sin(angle)*length))); 

		}
		else {
			float rad60 = (float) (Math.PI/3);
			
			//draw line 1/3 of length
			drawTree(marker, level-1, angle, x, y, length/3);
			
			x = (float) (x + length/3*Math.cos(angle));
			y = (float) (y - length/3*Math.sin(angle));
			
			//draw k-1 level curve, 60 degrees from where left off
			drawTree(marker, level-1, angle+rad60, x, y, length/3);
			
			x = (float) (x + length/3*Math.cos(angle+rad60));
			y = (float) (y - length/3*Math.sin(angle+rad60));
			
			//draw k-1 curve, -60 degrees from where left off
			drawTree(marker, level-1, angle-rad60, x, y, length/3);
			
			x = (float) (x + length/3*(Math.cos(angle-rad60)));
			y = (float) (y - length/3*Math.sin(angle-rad60));
			
			//draw k-1 curve, where previous left off
			drawTree(marker, level-1, angle, x, y, length/3);
		}
	}

}
