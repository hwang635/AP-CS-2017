
public class Statistics {

	private int[] data;
	private int actualLength;
	private int numModes;

	public Statistics(int maxLength) {
		//initialises data to length maxLength
		data = new int[maxLength];
		actualLength = 0;
		numModes = 0;
	}

	public void readData(String filename) {
		//creates an ArrayReader obj
		//fillArray method to get data from file

		ArrayReader reader = new ArrayReader(filename);
		actualLength = reader.fillArray(data);
	}

	public void print() {
		//print out each element in data to the commandline
		/*for(int j = 0; j<actualLength; j++) {
			System.out.println(data[j]);
		} */

		int compactLength = compact(data, data.length);
		for(int i = 0; i<compactLength; i++) {
			System.out.println(data[i]);
		}
	}

	//calculates the average + returns it as a double
	public double calcAverage() {
		long total = 0;

		for(int i = 0; i<actualLength; i++) {
			total += data[i];
		}

		System.out.println("total" + total + ", length " + actualLength);

		return total/(double)actualLength;
	}

	public double calcStdDev() {
		double avg = calcAverage();
		double sum = 0;

		for(int i = 0; i<actualLength; i++) {
			sum += Math.pow(avg-data[i], 2);
		}

		sum = sum/(actualLength-1);

		return Math.pow(sum, 0.5);
	}

	//only finds one mode
	public int[] findMode() {
		int modeCount = 1;
		int[] mode = new int[actualLength];
		int indCount;

		//first mode, finds the number of times repeated
		for(int i = 0; i<actualLength; i++) {
			indCount = 0;
			int choice = data[i];

			for(int x = 0; x<actualLength; x++) {
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

		for(int j = 0; j<actualLength; j++) {
			indCount = 0;
			int choice2 = data[j];

			for(int check = 0; check<actualLength; check++) {
				if(choice2 == mode[check]) {
					duplicate = true;
					break;
				}

			}

			for(int x = 0; x<actualLength; x++) {
				if(choice2 == data[x]) {
					indCount++;
				}

				if(indCount == modeCount ) {
					if(duplicate == false) {
						mode[numOfModes] = choice2;
						if(numOfModes<actualLength-1)
							numOfModes++;
					}
				}
			} //end of x loop

			duplicate = false;
		} //end of j 

		numModes = numOfModes;
		return mode;

	} //end of method

	public int getNumModes() {
		return numModes;
	}

	public int compact(int[] data, int size) {
		int numReal = 0;

		for(int i = 0; i<size; i++) {
			if(data[i] != 0) {
				data[numReal] = data[i];
				numReal++;
			}
			else
				data[size-numReal+2] = 0;
		}

		return (actualLength = numReal);
	}
}