package example.junit.project.entities;

/**
 * Class with the sole purpose of a prelude to a registrated user
 * 
 * @author a.vulchev
 *
 */
public class Person {

	private String firstName;
	private String lastName;
	private int age;
	private boolean isMale;

	/**
	 * No-args constructor for class "Person"
	 */
	public Person() {
		super();
	}

	/**
	 * All argumenstr Constructor for class "Person"
	 * 
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param isMale
	 */
	public Person(String firstName, String lastName, int age, boolean isMale) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.isMale = isMale;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isMale() {
		return isMale;
	}

	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", isMale=" + isMale
				+ "]";
	}

}
