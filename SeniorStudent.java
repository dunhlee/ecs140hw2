package hw2;

public class SeniorStudent extends NonDegreeStudent {
	private final int COST_PER_TERM = 100;
	private final int FEE_PER_ADDITIONAL_CREDIT = 50;
	private final int DEFAULT_CREDIT_THRESHOLD = 6;
	
	//default constructor
	//find a way to show an error if an age below 65 is inputed
	public SeniorStudent(String first_name, String last_name, int student_id, int student_age,
			int credits_enrolled) 
	{
		super(first_name, last_name, student_id, student_age, credits_enrolled);
	}
	
	public void printData() {
		super.printData();
		System.out.println();
		System.out.println(getFirstName() + " is a senior citizen student enrolled in " + getCreditsEnrolled() + " credits");
	}
	
	public int computeFees() {
		if (getCreditsEnrolled() <= DEFAULT_CREDIT_THRESHOLD) {
			return COST_PER_TERM;
		} 
		
		int additional_credits = getCreditsEnrolled() - DEFAULT_CREDIT_THRESHOLD;
		return COST_PER_TERM + (additional_credits * FEE_PER_ADDITIONAL_CREDIT);
	}
}
