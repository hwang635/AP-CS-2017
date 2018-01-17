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
		
		int x = (int) (Math.random()*4);
		int y = (int) (Math.random()*4);
		int x2 = (int) (Math.random()*4);
		int y2 = (int) (Math.random()*4);
		
		while(x2 == x) {
			x2 = (int) (Math.random()*4);
		}
		while(y2 == y) {
			y2 = (int) (Math.random()*4);
		}
		
		int n = 2;
		if(Math.random()*4>3) //random 4 or 2, smaller chance of getting 4
			n = 4;
		grid[x][y] = n; //could be 4 or 2
		grid[x2][y2] = 2; //because there is always at one 2
	}

	//Makes one move or squish
	public void step() {

	}

	// Runs n turns of the Game Of Life
	public void step(int n) {
		int x = (int) (Math.random()*4);
		int y = (int) (Math.random()*4);

		while(grid[x][y] != 0) {
			x = (int) (Math.random()*4);
			y = (int) (Math.random()*4);
		}
		
		//make new blocc
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
				if(grid[j][i] == 2) // == true
					marker.fill(0);
				else if(grid[j][i] == 4)
					marker.fill(255);
				
				marker.rect(cellWidth*j+x, cellHeight*i+y, cellWidth, cellHeight);
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