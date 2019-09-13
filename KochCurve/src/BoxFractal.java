import processing.core.PApplet;

public class BoxFractal {
	
	private int level;
	private int length;

	// TO DO

	public BoxFractal(int level, int length) {
		this.level = level;
		this.length = length;
	}

	public void draw(PApplet marker) {
		drawBox(marker, this.level, 50, 100, this.length);
	}

	private void drawBox(PApplet marker, int level, float x, float y, float length) {
		if(level < 1) {
			marker.noFill();
			marker.rect(x, y, length, length);	
		}
		else {				
			drawBox(marker, level-1, x, y, length/3); //top left
			drawBox(marker, level-1, x+2*length/3, y, length/3); //top right
			drawBox(marker, level-1, x+length/3, y+length/3, length/3); //centre
			drawBox(marker, level-1, x, y+length*2/3, length/3); //bottom left
			drawBox(marker, level-1, x+2*length/3, y+length*2/3, length/3); //bottom right
		}
	}

}
