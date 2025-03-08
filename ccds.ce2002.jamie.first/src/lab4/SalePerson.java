package lab4;

@SuppressWarnings("rawtypes")
public class SalePerson implements Comparable {
	private String firstName;
	private String lastName;
	private int totalSales;

	public SalePerson(String firstName, String lastName, int totalSales) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.totalSales=totalSales;
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

	public String toString() {
		return String.format("%s , %s : %d", lastName,firstName,totalSales);
	}

	public boolean equals(Object o) {
		if(o instanceof SalePerson) { // Check if o is a saleperson obj , to avoid runtime error
			SalePerson sp = (SalePerson)o;
			/* checks if the first name and last name of both obj matches, if it does, return true */
			return (this.firstName == sp.getFirstNme() && this.lastName == sp.getLastName());
		}
		return false;
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof SalePerson) {
			SalePerson sp = (SalePerson)o;
			if(this.totalSales == sp.getTotalSales())
				return this.lastName.compareTo(sp.getLastName());
			else
				if(this.totalSales > sp.getTotalSales())
					return 1;
				else
					return -1;
		}
		return 2;
	}
}
