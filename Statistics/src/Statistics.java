
public class Statistics {

	private int[] data;
	private int arrayLength;
	
	public Statistics(int maxLength) {
		//initialises data to length maxLength
		data = new int[maxLength];
	}
	
	public void readData(String filename) {
		//creates an ArrayReader obj
		//fillArray method to get data from file
		
		ArrayReader reader = new ArrayReader("numbers.txt");
		reader.fillArray(data);
		arrayLength = 0;
	}
	
	public void read() {
		//print out each element in data to the commandline
		for(int i: data) {
			System.out.println(i);
		}
	}
	
	//calculates the average + returns it as a double
	public double calcAverage() {
		long total = 0;
		
		for(int i: data) {
			total += i;
		}
		
		return total/data.length;
	}
	
	public double calcStdDev() {
		double avg = calcAverage();
		double sum = 0;

		for(int i: data) {
			sum += Math.pow(avg-i, 2);
		}
		
		sum = sum/(data.length-1);
		
		return Math.pow(sum/(data.length-1), 0.5);
	}
	
	public int[] findMode() {
		int modeCount = 1;
		int[] mode = new int[1];
		
		for(int i: data) {
			int indCount = 0;
			
			for(int x = 0; i<data.length; i++) {
				if(i == data[x]) {
					indCount++;
				}
			}
			
			if(indCount > modeCount) {
				modeCount = indCount;
				mode[0] = i;
			}
			
		}
		return mode;
	}
}