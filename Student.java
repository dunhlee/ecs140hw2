package hw2;

public abstract class Student {
	private String first_name;
	private String last_name;
	private int student_id;
	private int student_age;
	private int credits_enrolled;
	
	//constructor
	public Student(String first_name, String last_name, int student_id, int student_age,
			int credits_enrolled)
	{
		this.first_name = first_name;
		this.last_name = last_name;
		this.student_id = student_id;
		this.student_age = student_age;
		this.credits_enrolled = credits_enrolled;
	};
	
	//Getters
	public String getFirstName() {
		return first_name;
	}
	
	public String getLastName() {
		return last_name;
	}
	
	public int getStudentId() {
		return student_id;
	}
	
	public int getStudentAge() {
		return student_age;
	}
	
	public int getCreditsEnrolled() {
		return credits_enrolled;
	}
	
	public void printData() {
		System.out.println("ID number: " + getStudentId());
		System.out.println("Name:      " + getFirstName() + " " + getLastName());
		System.out.println("Age:       " + getStudentAge());
	}
	
	public abstract int computeFees();
}
