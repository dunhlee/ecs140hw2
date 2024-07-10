package hw2;

public class CertificateStudent extends NonDegreeStudent {
	private Major major;
	private final int COST_PER_TERM = 700;
	private final int COST_PER_CREDIT = 300;
	
	public CertificateStudent(String first_name, String last_name, int student_id, int student_age,
			int credits_enrolled, Major major) 
	{
		super(first_name, last_name, student_id, student_age, credits_enrolled);
		this.major = major;
	}
	
	public void printData() {
		super.printData();
		System.out.println();
		System.out.println(getFirstName() + " is a certificate student enrolled in " + getCreditsEnrolled() + " credits");
		System.out.println(getFirstName() + " is pursuing a certificate in " + major.displayMajor());
	}
	
	public int computeFees() {
		return COST_PER_TERM + (COST_PER_CREDIT * getCreditsEnrolled());
	}
}
