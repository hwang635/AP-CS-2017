
public class ResizableArray {

	private int[] data;
	private int size;

	private final int MAX = 1000;

	public ResizableArray() {
		data = new int[MAX];
		size = 0;
	}

	public void add(int value) {
		data[size] = value;
		size++;
	}

	//value is the number you want to get rid of
	public void removeAll(int value) {
		int numReal = 0;

		for(int i = 0; i<size; i++) {
			if(data[i] != value) {
				data[numReal] = data[i];
				numReal++;
			}
			else
				data[size-numReal+2] = 0;
		}
		size = numReal;
	}

	//public void addAll(int[] data)
	//public fboolean equals(Object other
	//public int[] toArray() 

	//returns array[index] the value that was removed
	public int remove(int index) {
		int removed = data[index];

		for(int i = index; i<size-1; i++) {
			data[i] = data[i+1];
		}
		size--;

		return removed;
	}

	public int getSize() {
		return size;
	}

	public void insert(int index, int value) {
		if(index<0 || index>size-1) 
			throw new IllegalArgumentException("Bad index");
		else {			
			for(int i = size+1; i>index; i--) {
				data[i] = data[i-1];
				//System.out.println("data[i+1], data[i]" + data[i+1] + " " + data[i]);
			} //end of loop
			
			data[index] = value;
			size++;
		}//end of big else
	}

	public String toString() {
		String output = "[";
		for(int i = 0; i<size; i++) {
			if(i<size-1)
				output += (data[i] + ", ");
			else
				output += data[i];
		}
		output += "]";

		return output;
	}

	public int get(int index) {
		return data[index];
	}

	public void setValue(int index, int value) {
		data[index] = value;
	}

	//finds the value's index in the array, returns -1 if not there
	public int indexOf(int value) {
		return 0;
	}

	//switches the values at the positions
	public void swap(int index1, int index2) {

	}

	//public void subArray(int startIndex, int endIndex)
	//public void reverse()
	//public int frequency() (int value)

}
