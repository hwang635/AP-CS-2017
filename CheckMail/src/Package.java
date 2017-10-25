//flowchart by Johnry Zhao
public class Package {
	
	//private double dim1, dim2, dim3, weight;
	private double x, y, z, weight;
	
	public Package(double dim1, double dim2, double dim3, double weight) {
		x = dim1;
		y = dim2;
		z = dim3;
		this.weight = weight;
	}
	
	public void checkStatus() {
		
		//x>y part of flowchart if false
		if(!(x>y)) { //switches x and y if x is less than/equal to y
			double b = x;
			x = y;
			y = b;
		} //does nothing if x>y
				
		//y>z part if false
		if(!(y>z)) { //switches y and z if z is less than/equal to y
			double a = z;
			z = y ;
			y = a;
		} //does nothing if y>z
		
		//x>y part of flowchart if false, returns to x>y after checking y and z?? why johnry
		if(!(x>y)) { //switches x and y if x is less than/equal to y
			double b = x;
			x = y;
			y = b;
		} //does nothing if x>y
				
		//y>z part if false, second time after returning to xy
		if(!(y>z)) { //switches y and z if z is less than/equal to y
			double a = z;
			z = y ;
			y = a;
		} //does nothing if y>z
		
		//after both are true
		
		boolean tooLarge = !(x+2*y+2*z <= 100);
		boolean tooHeavy;
		
		if(weight<=70) //weight is ok
			tooHeavy = false;
		else
			tooHeavy = true;
		
		//added own code to print out result
		
		if(tooLarge == true && tooHeavy == true)
			System.out.println("The package is too large and too heavy.");
		else if(tooLarge == true) //only too large, light enough
			System.out.println("The package is too large.");
		else if(tooHeavy == true) //only too heavy
			System.out.println("The package is too heavy.");
		else //if none are true, it's good
			System.out.println("The package is acceptable");
	}

}
