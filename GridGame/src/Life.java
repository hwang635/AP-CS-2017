import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import processing.core.PApplet;
/*
	Represents a Game Of Life grid.

	Coded by:
	Modified on:
 */

public class Life {

	private int[][] grid;

	// Constructs an empty grid
	public Life() {
		grid = new int[4][4];

		for(int i = 0; i<2; i++) {
			int x = (int) (Math.random()*4);
			int y = (int) (Math.random()*4);

			int n  = 2;
			if(grid[x][y] == 0) {
				if(Math.random()*4>3) //random 4 or 2, smaller chance of getting 4
					n = 4;
				grid[x][y] = n; //could be 4 or 2
			}
			else
				i--;
		}
	}

	//Makes one move or squish
	public void step() {


	}

	// Runs n = 1 which key was pressed
	// 1 = up, 2 = down, 3 = right, 4 = left
	public void step(int n) {
		int x = (int) (Math.random()*4);
		int y = (int) (Math.random()*4);

		while(grid[x][y] != 0) {
			x = (int) (Math.random()*4);
			y = (int) (Math.random()*4);
		}

		grid[x][y] = 2;
		
		//diff loops for each direction
		//move in direction
		//then squish
	}

	// Formats this Life grid as a String to be printed (one call to this method returns the whole multi-line grid)
	public String toString() {
		String response = "";

		for(int i = 0; i<grid[0].length; i++) {
			for(int j = 0; j<grid.length; j++) {
				response += (grid[j][i] + " ");
			}
			response += "\n";
		}

		return response;
	}

	// Reads in array data from a simple text file containing asterisks (*)
	public void readData (String filename, boolean[][] gameData) {
		File dataFile = new File(filename);

		if (dataFile.exists()) {
			int count = 0;

			FileReader reader = null;
			Scanner in = null;
			try {
				reader = new FileReader(dataFile);
				in = new Scanner(reader);

				while (in.hasNext()) {
					String line = in.nextLine();
					for(int i = 0; i < line.length(); i++)
						if (i < gameData.length && count < gameData[i].length && line.charAt(i)=='*')
							gameData[i][count] = true;

					count++;
				}
			} catch (IOException ex) {
				throw new IllegalArgumentException("Data file " + filename + " cannot be read.");
			} finally {
				if (in != null)
					in.close();
			}

		} else {
			throw new IllegalArgumentException("Data file " + filename + " does not exist.");
		}
	}

	/**
	 * Optionally, complete this method to draw the grid on a PApplet.
	 * 
	 * @param marker The PApplet used for drawing.
	 * @param x The x pixel coordinate of the upper left corner of the grid drawing. 
	 * @param y The y pixel coordinate of the upper left corner of the grid drawing.
	 * @param width The pixel width of the grid drawing.
	 * @param height The pixel height of the grid drawing.
	 */
	public void draw(PApplet marker, float x, float y, float width, float height) {
		marker.pushStyle();

		float cellWidth = width/grid.length;
		float cellHeight = height/grid[0].length;

		for(int i = 0; i<grid[0].length; i++) {
			for(int j = 0; j<grid.length; j++) {

				if(grid[j][i] == 0) 
					marker.fill(240, 229, 204);
				else {

					if(grid[j][i] == 2) {// == true
						marker.fill(238, 228, 218);
					}
					else if(grid[j][i] == 4) {
						marker.fill(240, 224, 200);
					}
					else if(grid[j][i] == 8) {
						marker.fill(242, 177, 121);
					}
					else if(grid[i][j] == 16) {
						marker.fill(245, 149, 99);
					}
					else if(grid[i][j] == 32) {
						marker.fill(246, 124, 95);
					}
					else if(grid[i][j] == 64) {
						marker.fill(246, 94, 59);
					}
					else if(grid[i][j] == 128) {
						marker.fill(237, 207, 114);
					}
					else if(grid[i][j] == 256) {
						marker.fill(237, 204, 97);
					}
					else if(grid[i][j] == 512) {
						marker.fill(237, 200, 80);
					}
					else if(grid[i][j] == 1024) {
						marker.fill(237, 197, 63);
					}
					else { //2048 or more
						marker.fill(252, 221, 119);
					} 
				} //end of has a number else

				marker.rect(cellWidth*j+x, cellHeight*i+y, cellWidth, cellHeight);
				marker.textSize(20);
				marker.fill(0);
				if(grid[j][i] != 0) {
					marker.text(grid[j][i],cellWidth*j+x+20, cellHeight*i+y+50);
				}

			} //end of j
		} //end of i


		marker.popStyle(); //makes it so the marker setting here don't affect things drawn elsewhere
	}

	/**
	 * Optionally, complete this method to determine which element of the grid matches with a
	 * particular pixel coordinate.
	 * 
	 * @param p A Point object representing a graphical pixel coordinate.
	 * @param x The x pixel coordinate of the upper left corner of the grid drawing. 
	 * @param y The y pixel coordinate of the upper left corner of the grid drawing.
	 * @param width The pixel width of the grid drawing.
	 * @param height The pixel height of the grid drawing.
	 * @return A Point object representing a coordinate within the game of life grid.
	 */
	public Point clickToIndex(Point p, float x, float y, float width, float height) {
		float cellWidth = width/grid.length;
		float cellHeight = height/grid[0].length;

		int j = (int) ((p.x-x)/cellWidth);
		int i = (int) ((p.y-y)/cellHeight);

		if(j<0 || j>= grid.length)
			return null;
		if(i<0 || i>= grid[0].length)
			return null;

		return new Point(j,i);
	}

}