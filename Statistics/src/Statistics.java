
public class Statistics {

	private int[] data;
	private int arrayLength;

	public Statistics(int maxLength) {
		//initialises data to length maxLength
		data = new int[maxLength];
		arrayLength = 0;
	}

	public void readData(String filename) {
		//creates an ArrayReader obj
		//fillArray method to get data from file

		ArrayReader reader = new ArrayReader(filename);
		arrayLength = reader.fillArray(data);
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

		for(int i = 0; i<arrayLength; i++) {
			total += data[i];
		}

		return total/(double)arrayLength;
	}

	public double calcStdDev() {
		double avg = calcAverage();
		double sum = 0;

		for(int i = 0; i<arrayLength; i++) {
			sum += Math.pow(avg-data[i], 2);
		}

		sum = sum/(arrayLength-1);

		return Math.pow(sum, 0.5);
	}

	//only finds one mode
	public int[] findMode() {
		int modeCount = 1;
		int[] mode = new int[arrayLength];
		int indCount;

		//first mode, finds the number of times repeated
		for(int i = 0; i<arrayLength; i++) {
			indCount = 0;
			int choice = data[i];

			for(int x = 0; x<arrayLength; x++) {
				if(choice == data[x]) {
					indCount++;
				}

				if(indCount > modeCount) {
					modeCount = indCount;
					mode[0] = choice;
				}
			}	
		}

		//for second/more modes
		boolean duplicate = false;
		int numOfModes = 1;

		for(int j = 0; j<arrayLength; j++) {
			indCount = 0;
			int choice2 = data[j];

			for(int check = 0; check<mode.length; check++) {
				if(choice2 == mode[check]) {
					duplicate = true;
					break;
				}

			}

			for(int x = 0; x<arrayLength; x++) {
				if(choice2 == data[x]) {
					indCount++;
				}

				if(indCount == modeCount ) {
					if(duplicate == false) {
						mode[numOfModes] = choice2;
						if(numOfModes<arrayLength-1)
							numOfModes++;
					}
				}
			} //end of x loop

			duplicate = false;
		} //end of j loop		
		return mode;

	} //end of method
}