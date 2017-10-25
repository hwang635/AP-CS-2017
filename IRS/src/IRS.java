

/*
 * 
 * Add constructor with fields
 * 
 * The income might want to be a double since the program breaks if a user has a decimal income
 * Nice job incorporating all user-inputed elements in one method
 * Might want to somehow prevent the user from entering negative incomes
 * 
 * a. 9
 * b. 9 
 * c. 3
 * d. 5
 * 
 */
public class IRS {
	
	int status;
	double income;
	
	public IRS(int status, double income) {
		this.status = status;
		this.income = income;
		
	}

	public double calcTax () {

		double tax = 0;

		if(status == 1) { //single
			if(income <= 27050)
				tax = 0.15*income;
			else if(income <= 65550)
				tax = 4057.5 + .275*(income-27050);
			else if(income <= 136750) 
				tax = 14645 + .305*(income - 65550);
			else if(income <= 297350)
				tax = 36361 + .355*(income - 136750);
			else
				tax = 93374 + .391*(income - 297350);				
		}
		else if(status == 2) { //married
			if(income <= 45200)
				tax = 0.15*income;
			else if(income <= 109250)
				tax = 6780 + .275*(income - 45200);
			else if(income <= 166500)
				tax = 24393.75 + .305*(income-109250);
			else if(income <= 297350)
				tax = 41855 + .355*(income-166500);
			else
				tax = 88306 + .391*(income - 297350);				
		}
		else
			tax = -1; //neither married or single, entered uncalc status
		
		tax = Math.round(tax*100)/100.0; //rounded to two decimal points
		return tax;
	}

}
