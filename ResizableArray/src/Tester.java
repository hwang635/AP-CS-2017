
public class Tester {

	public static void main(String[] args) {
		ResizableArray data = new ResizableArray();
		
		data.add(5);
		data.add(0);
		data.add(52);
		data.add(1);
		data.add(8);
		data.add(0);
		
		System.out.println(data);
		data.remove(0);
		System.out.println(data);
	}
}
