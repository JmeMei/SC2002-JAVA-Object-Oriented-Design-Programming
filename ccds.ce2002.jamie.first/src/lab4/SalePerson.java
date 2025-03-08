package lab4;

//@SuppressWarnings("rawtypes")
public class SalePerson implements Comparable<SalePerson>{
	private String firstName;
	private String lastName;
	private int totalSales;

	public SalePerson(String firstName, String lastName, int totalSales) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.totalSales=totalSales;
	}

	public String toString() {
		return String.format("%s , %s : %d", lastName,firstName,totalSales);
	}

	public boolean equals(Object o) {
		if(o instanceof SalePerson) { // Check if o is a saleperson obj , to avoid runtime error
			SalePerson other = (SalePerson) o;
			/* checks if the first name and last name of both obj matches, if it does, return true */
			return (this.firstName == other.getFirstNme() && this.lastName == other.getLastName());
		}
		else if (o == null) {
			return false;
		}
		return false;
	}

	//compareTo() compares itself with other instances
	public int compareTo(SalePerson other) {
		if(this.totalSales > other.totalSales) return -1; 
		
		else if (this.totalSales < other.totalSales) return 1;
		
		else return this.lastName.compareTo(other.lastName); //if they have the same totalSales, list according to their last names 		
		
	}
	
	public String getFirstNme() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getTotalSales() {
		return totalSales;
	}
	
}
