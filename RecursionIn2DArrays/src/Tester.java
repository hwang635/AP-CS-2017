
public class Tester {
	
	public static void main(String[] args) {
		Maze grid = new Maze("griddata\\test1.txt");
		grid.solve();
		System.out.println(grid);
	}

}
