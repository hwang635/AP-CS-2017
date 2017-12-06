
public class Tester {

	public static void main(String[] args) {
		ResizableArray data = new ResizableArray();
		ResizableArray data2 = new ResizableArray();
		
		data.add(5);
		data.add(3);
		data.add(2);
		data.add(1);
		data.add(8);
				
		System.out.println(data);
		//data.remove(0);
		//data.insert(3, -1);
		//System.out.println(data);
		data.insert(5, 7);
		System.out.println(data);
	}
}
