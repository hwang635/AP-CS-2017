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

	private boolean[][] grid;

	// Constructs an empty grid
	public Life() {
		grid = new boolean[20][20];
	}

	// Constructs the grid defined in the file specified
	public Life(String filename) {
		grid = new boolean[20][20];
		readData(filename, grid);
	}

	// Runs a single turn of the Game Of Life
	public void step() {
		int n = 0;
		
		int[][] neighbours = new int[grid.length][grid[0].length];
		
		for(int i = 0; i<grid.length; i++) {
			for(int j = 0; j<grid[0].length; j++) {
				n = findNeighbours(i,j); // grid[j,i]
				neighbours[i][j] = n;
			}
			
		} //end of i for
		
		for(int i = 0; i<grid.length; i++) {
			for(int j = 0; j<grid[0].length; j++) {
				if(n<=1)
					grid[i][j] = false;
				else if(n<=3) 
					grid[i][j] = true;
				else
					grid[i][j] = false;
			}
		}
		/*if(n<=1) //zero or one neighbours
			grid[j][i] = false;
		else if(n<=3) // two or three
			grid[j][i] = true;
		else // four or more
			grid[j][i] = false; */
	}

	//
	public int findNeighbours(int x, int y) {
		int neighbours = 0;
		
		if(grid[x][y+1]) //top, down, sides
			neighbours++;
		if(grid[x][y-1])
			neighbours++;
		if(grid[x-1][y])
			neighbours++;
		if(grid[x+1][y])
			neighbours++;
		if(grid[x+1][y+1]) //corners
			neighbours++;
		if(grid[x+1][y-1])
			neighbours++;
		if(grid[x-1][y+1])
			neighbours++;
		if(grid[x-1][y-1])
			neighbours++;
		
		return neighbours;
	}
	// Runs n turns of the Game Of Life
	public void step(int n) {
	}

	// Formats this Life grid as a String to be printed (one call to this method returns the whole multi-line grid)
	public String toString() {
		String response = "";

		for(int i = 0; i<grid[0].length; i++) {
			for(int j = 0; j<grid.length; j++) {
				if(grid[j][i]) // == true
					response += "*";
				else
					response += "-";
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
		return null;
	}

	/**
	 * Optionally, complete this method to toggle a cell in the game of life grid
	 * between alive and dead.
	 * 
	 * @param i The x coordinate of the cell in the grid.
	 * @param j The y coordinate of the cell in the grid.
	 */
	public void toggleCell(int i, int j) {
	}



}