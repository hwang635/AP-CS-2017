
public class Tester {
	
	public static void main(String[] args) {
		Life grid = new Life("griddata\\life tester.txt");
		System.out.println(grid);
		
		grid.step();
	}

}
