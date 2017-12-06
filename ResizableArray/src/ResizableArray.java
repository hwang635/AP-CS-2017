import java.lang.reflect.Array;
import java.util.Arrays;

public class ResizableArray {

	private int[] data;
	private int size;

	private int INITIAL_LENGTH = 1;

	public ResizableArray() {
		data = new int[INITIAL_LENGTH];
		size = 0;
	}

	public void add(int value) {
		if(size >= INITIAL_LENGTH) {
			resize();
		}

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

	public void resize() {
		//creates a new, larger array
		//copies all element from data into new array
		//set the data field to the new array
		INITIAL_LENGTH += 25;
		int[] newData = new int[INITIAL_LENGTH];

		for(int i = 0; i<size; i++) {
			newData[i] = data[i];
		}

		data = newData;
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

	public int size() {
		return size;
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

	public void insert(int index, int value) {
		if(index<0 || index>size) 
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
	public int get(int index) {
		return data[index];
	}

	public void set(int index, int value) {
		data[index] = value;
	}

	public void sort() {
		Arrays.sort(data, 0, size);
	}

	//finds the value's index in the array, returns -1 if not there
	public int indexOf(int value) {
		int count = 0;
		for(int i = 0; i<size; i++) {
			if(data[i] == value) 
				count++;
		}
		
		if(count == 0)
			count = -1;
		
		return 0;
	}

	//switches the values at the positions
	public void swap(int index1, int index2) {
		int temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}
	
	public boolean equals(Object other) {
		boolean output = true;
		
		ResizableArray otherArray = new ResizableArray();
		otherArray = (ResizableArray)other;
		
		if(otherArray.size() != data.length)
			output = false;
		for(int i = 0; i<size; i++) {
			if(data[i] != otherArray.get(i))
				output = false;
		}
		
		return output;
	}

	public int[] toArray() {
		int[] newData = new int[size];
		
		for(int i = 0; i<size; i++) {
			newData[i] = data[i];
		}
		
		return newData;
	}
}
