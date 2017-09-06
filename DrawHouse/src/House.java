import java.awt.Dimension;
import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;

public class House{

	int houseX;
	int houseY;
	int width;
	int height;

	public House() {
		houseX = 100;
		houseY = 180;
		width = 300;
		height = 200;
	}

	public void draw(PApplet drawer) {

		drawer.stroke(0, 0, 0);	
		//building
		drawer.fill(250,228,195);
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
		
		//background
		
	}

	//method that moves house according to arrow keys
	public void move(int i) {
		if(i == 1)
			houseY -= 10;
		else if(i == 2)
			houseY += 10;
		else if(i == 3)
			houseX -=10;
		else if(i == 4)
			houseX += 10;
	}

	//called in DrawingSurface to make house bigger/smaller
	public void scale(int i) {
		if(i == 1) {
			if(width > 15) {
				width -= 15;
				height -= 10;
			}
		}
		else if(i == 2) {
			if(width < 475) {
				width += 15;
				height += 10;
			}
		}
	}

}