
public class Tester {

	public static void main(String[] args) {
		ResizableArray data = new ResizableArray();
		ResizableArray data2 = new ResizableArray();
		
		data.add(5);
		data.add(3);
		data.add(2);
		data.add(1);
		data.add(8);

		data2.add(5);
		data2.add(3);
		data2.add(2);
		data2.add(1);
		data2.add(8);
		
				
		System.out.println(data);
		System.out.println(data2);
		//data.remove(0);
		//data.insert(3, -1);
		//System.out.println(data);
		//data.insert(5, 7);
		//System.out.println(data);
		data.sort();
		//System.out.println(data);
		
		boolean check = data2.equals(data);

		System.out.println(check);

		
	}
}
