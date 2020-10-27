package banking;

public class Person extends  AccountHolder{
	private String firstName;
	private String lastName;

	public Person(String firstName, String lastName, int idNumber) {
		super(idNumber);
		// complete the function
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		// complete the function
        return firstName;
	}

	public String getLastName() {
		// complete the function
        return lastName;
	}

	public boolean equals(Person per){
		if(this.getIdNumber() == per.getIdNumber()){
			return  true;
		}
		return  false;
	}
}
