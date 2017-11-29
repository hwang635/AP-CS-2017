
public class StatisticsTester {

	public static void main(String[] args) {

		Statistics tester = new Statistics(10000);
		tester.readData("compact.txt");
		tester.print();
		
		double avg = tester.calcAverage();
		double sd = tester.calcStdDev();
		int[] mode = tester.findMode();

		System.out.println("Average is " + avg);
		System.out.println("Standard deviation is " + sd);
		
		System.out.println("Mode(s) = ");
		System.out.println(mode[0]);
		for(int i = 1; i<tester.getNumModes(); i++) {
			if (!(mode[i] == mode[i-1]))
				System.out.println(mode[i]);				
		}	
		
		
	}
}
