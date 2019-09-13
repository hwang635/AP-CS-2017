
public class Tester {
	
	public static void main(String[] args) {
		//prints out solution to txt file
		Maze grid = new Maze("griddata\\test3.txt");
		grid.solve();
		System.out.println(grid);
	}

}
