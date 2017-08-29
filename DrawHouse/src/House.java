import java.awt.Dimension;
import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class House{

	int houseX = 100;
	int houseY = 180;
	int width = 300;
	int height = 200;
	
	public void draw(PApplet drawer) {
		drawer.background(255, 255, 255);

		drawer.stroke(0, 0, 0);	
		//building
		drawer.rect(houseX, houseY, width, height);
		drawer.stroke(180, 100, 80);
		drawer.fill(150, 80, 80);
		drawer.triangle(houseX, houseY, houseX + width/2, houseY - height/4, houseX + width, houseY);
		//door
		drawer.stroke(200, 120, 5);
		drawer.fill(200, 120, 5);
		drawer.rect(houseX + (int)(0.4*width), houseY + (int)(0.55*height), width/5, (int)(0.4*height));
		drawer.stroke(5);
		drawer.fill(0);
		drawer.ellipse(houseX + (int)(0.56*width), houseY + 3*height/4, width/50, width/50);
		//windows
		drawer.stroke(135, 206, 235);
		drawer.fill(135, 206, 235);
		drawer.rect(houseX + (int)(0.12*width), houseY + height/5, width/6, width/6);
		drawer.rect(houseX + (int)(0.71*width), houseY + height/5, width/6, width/6);
		drawer.noFill();
	}

	//4 methods that move house according to arrow keys
	public void moveUp() {
		if(houseY>50)
			houseY -= 10;
	}

	public void moveDown() {
		if(houseY<300)
			houseY += 10;
	}

	public void moveLeft() {
		if(houseX>0)
			houseX -= 10;
	}

	public void moveRight() {
		if(houseX<200)
			houseX += 10;
	}
	
	//called in DrawingSurface to make house bigger/smaller
	public void scaleDown( ) {

		if(width > 15) {
			width -= 15;
			height -= 10;
		}
	}

	public void scaleUp() {
		if(width < 475) {
			width += 15;
			height += 10;
		}
	}
}