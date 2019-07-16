import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


/*

	Represents a 2D maze.
 */

public class Maze {

	private static final int rows = 20;
	private static final int cols = 20;

	private char[][] grid;

	// Constructs empty grid
	public Maze() {
		grid = new char[20][20];
	}

	// Constructs the grid defined in the file specified
	public Maze(String filename) {
		grid = new char[20][20];
		readData(filename, grid);
	}

	// Attempts to find a path through the maze and returns whether a path was found or not
	public boolean solve() {
		int[] coordinates = new int[2];
		findC(coordinates, 0, 0);
		//System.out.println("x = " + coordinates[0] + " y = " + coordinates[1]);
		return solve(coordinates[0], coordinates[1]);
	}

	// Private recursive version of solve()
	private boolean solve(int x, int y) {
		if(x<0 || x>grid.length-1 || y<0 || y>grid[0].length-1) // if out of bounds
			return false;
		else if(grid[x][y] == 'X') //reached goal
			return true;
		else if(grid[x][y] == '#' || grid[x][y] == '!' || grid[x][y] == '\u0000') //blocked or visited
			return false;
		else {
			grid[x][y] = '!';
			
			if(solve(x+1, y)) //right
				return true;
			if(solve(x-1, y)) //left
				return true;
			if(solve(x, y+1)) //up
				return true;
			if(solve(x, y-1)) //down
				return true;
			
			grid[x][y] = '.';
			
			return false;
		}
	}

	//Recursive version, finds the starting location (where C is)
	public void findC(int[] c, int x, int y) {
		if(x<0 || x>grid.length-1 || y<0 || y>grid[0].length-1) { //out of bounds
			if(y<0 || y>grid[0].length-1) { //y out of bounds, next x + reset y
				y = 0;
				x++;
				findC(c, x, y);
			}
		}
		else {
			if(grid[x][y] == 'C') { //base case
				c[0] = x;
				c[1] = y;
			}
			else {
				y++;
				findC(c, x, y);
			}
		}
	}

	//loop version
	public void findC(int[] coordinates) {

		for(int i = 0; i<grid.length; i++) {
			for (int j = 0; j<grid[0].length; j++) {
				if(grid[i][j] == 'C') {
					coordinates[0] = i;
					coordinates[1] = j;
				}
			}
		}
	}

	// Formats this grid as a String to be printed (one call to this method returns the whole multi-line grid)
	public String toString() {
		String response = "";

		for(int i = 0; i<grid[0].length; i++) {
			for(int j = 0; j<grid.length; j++) {
					response += grid[j][i];
			}
			response += "\n";
		}
		return response;
	}

	public void readData (String filename, char[][] gameData) {
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
						if (i < gameData.length && count < gameData[i].length)
							gameData[i][count] = line.charAt(i);

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

}