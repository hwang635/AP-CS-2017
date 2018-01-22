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
	boolean hasLost, has2048;
	int score;

	// Constructs an empty grid
	public Life() {
		score = 0;
		hasLost = false;
		has2048 = false;
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

	//direction = 1 up, 2 down, 3 right, 4 left
	public int getSlide(int i, int j, int direction) {
		int count = 1;

		if(direction == 1) {
			while((j-count)>-1 && this.isEmpty(i, j-count) == true)
				count++;
		}
		else if(direction == 2) {
			while((j+count)<grid.length && this.isEmpty(i, j+count) == true)
				count++;
		}
		else if(direction == 3) {
			while((i+count)<grid.length && this.isEmpty(i+count, j) == true)
				count++;
		} 
		else if(direction == 4) {
			while((i-count)>-1 && this.isEmpty(i-count, j) == true)
				count++;
		}

		return count-1;
	}

	//moves the tiles when there are empty spots
	public void move(int i, int j, int xDistance, int yDistance) { 
		grid[i+xDistance][j+yDistance] = grid[i][j];
		grid[i][j] = 0;
	}

	// Runs n = 1 which key was pressed
	// 1 = up, 2 = down, 3 = right, 4 = left
	public void step(int n) {
		if(hasLost == false) {
			if(n == 1) { //up
				for(int i = 0; i<grid.length; i++) {
					for(int j = 1; j<grid.length; j++) {
						if(isEmpty(i, j-1)) {
							this.move(i,j, 0, -this.getSlide(i, j, 1));
						}
					} //end of j
					for(int j = 1; j<grid[0].length; j++) {
						if(grid[i][j-1] == grid[i][j]) {
							grid[i][j-1] += grid[i][j];
							score += grid[i][j-1];

							grid[i][j] = 0;
						}
					}
					for(int j = 1; j<grid.length; j++) {
						if(isEmpty(i, j-1)) {
							this.move(i,j, 0, -this.getSlide(i, j, 1));
						}
					} //end of j
				} //end of i
			}
			else if(n == 2) { //down
				for(int i = 0; i<grid.length; i++) {
					for(int j = grid[0].length-2; j>=0;j--) {
						if(isEmpty(i, j+1))
							this.move(i, j, 0, this.getSlide(i, j, 2));
					} //end of j
					for(int j = grid[0].length-2; j>=0;j--) {
						if(grid[i][j+1] == grid[i][j]) {
							grid[i][j+1] += grid[i][j]; 
							score += grid[i][j+1];
							grid[i][j] = 0;
						}
					}
					for(int j = grid[0].length-2; j>=0;j--) {
						if(isEmpty(i, j+1))
							this.move(i, j, 0, this.getSlide(i, j, 2));
					} //end of j
				} //end of i
			}
			else if(n == 3) { //right -->
				for(int i = grid.length-2; i>=0; i--) {
					for(int j = 0; j<grid[0].length; j++) {
						if(isEmpty(i+1, j))
							this.move(i, j, this.getSlide(i, j, 3), 0);
					} //end of j
				} //end of i
				for(int i = grid.length-2; i>=0; i--) {
					for(int j = 0; j<grid[0].length; j++) {
						if(grid[i+1][j] == grid[i][j]) {
							grid[i+1][j] += grid[i][j];
							score += grid[i+1][j];
							grid[i][j] = 0;
						}
					}
				}
				for(int i = grid.length-2; i>=0; i--) {
					for(int j = 0; j<grid[0].length; j++) {
						if(isEmpty(i+1, j))
							this.move(i, j, this.getSlide(i, j, 3), 0);
					} //end of j
				} //end of i
			}
			else if(n == 4) { //left <--w
				for(int i = 1; i<grid.length; i++) {
					for(int j = 0; j<grid[0].length; j++) {
						if(isEmpty(i-1,j))
							this.move(i, j, -this.getSlide(i, j, 4), 0);
					} //end of j
				} //end of i
				for(int i = 1; i<grid.length; i++) {
					for(int j = 0; j<grid[0].length;j++) {
						if(grid[i-1][j] == grid[i][j]) {
							grid[i-1][j] += grid[i][j];
							score += grid[i-1][j];
							grid[i][j] = 0;
						}
					}
				}
				for(int i = 1; i<grid.length; i++) {
					for(int j = 0; j<grid[0].length; j++) {
						if(isEmpty(i-1,j))
							this.move(i, j, -this.getSlide(i, j, 4), 0);
					} //end of j
				} //end of i
			}

			int x = (int) (Math.random()*4);
			int y = (int) (Math.random()*4);

			while(!isFull() && grid[x][y] != 0) {
				x = (int) (Math.random()*4);
				y = (int) (Math.random()*4);
			}

			hasLost = true;
			for(int i = 0; i<grid.length;i++) {
				for(int j = 0; j<grid.length;j++) {
					if(!isFull()) 
						hasLost = false;
					else if(canMerge(i,j) == true)
						hasLost = false;
				}
			} //checks that not filled

			if(!hasLost && !isFull() ) {
				int newInt = 2;
				if(Math.random()*4>3) //random 4 or 2, smaller chance of getting 4
					newInt = 4;
				grid[x][y] = newInt;
			}
		}
	}
	
	public boolean canMerge(int x, int y) {		
		if(y<grid[0].length-1) { //y+1
			if(grid[x][y+1] == grid[x][y])//top
				return true;
		} //end of y+1 if

		if(y>0) { //y-1
			if(grid[x][y-1] == grid[x][y]) //down
				return true;
		} //end of y-1 if
		if(x>0) {
			if(grid[x-1][y]== grid[x][y])
				return true;
		}
		if(x<grid.length-1) {
			if(grid[x+1][y]== grid[x][y])
				return true;
		}
		
		return false;
	}
	
	public boolean isFull() {
		for(int i = 0; i<grid.length; i++) {
			for(int j = 0; j<grid.length; j++) {
				if(grid[i][j] == 0) 
					return false;
			}
		}
		return true;
	}

	public int getScore() {
		return score;
	}
	
	public boolean get2048() {
		return has2048;
	}

	public boolean getLost() {
		return hasLost;
	}
	public boolean isEmpty (int i, int j) {
		if(grid[i][j] == 0)
			return true;
		else
			return false;
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
					else if(grid[j][i] == 16) {
						marker.fill(245, 149, 99);
					}
					else if(grid[j][i] == 32) {
						marker.fill(246, 124, 95);
					}
					else if(grid[j][i] == 64) {
						marker.fill(246, 94, 59);
					}
					else if(grid[j][i] == 128) {
						marker.fill(237, 207, 114);
					}
					else if(grid[j][i] == 256) {
						marker.fill(237, 204, 97);
					}
					else if(grid[j][i] == 512) {
						marker.fill(237, 200, 80);
					}
					else if(grid[j][i] == 1024) {
						marker.fill(237, 197, 63);
					}
					else { //2048 or more
						marker.fill(252, 221, 119);
						has2048 = true;
					} 
				} //end of has a number else

				marker.rect(cellWidth*j+x, cellHeight*i+y, cellWidth, cellHeight);
				marker.textSize(15);
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
	 * @param x The x pixel coordinate of the upper left corner of the grid draswing. 
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