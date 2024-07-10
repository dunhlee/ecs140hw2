package hw2;

public abstract class DegreeStudent extends Student {
	private Major major;
	private AcademicStanding academic_standing;
	private final int RECREATION_FEE = 100;
	private final int STUDENT_UNION_FEE = 50;
	private final int CREDIT_FEE = 275;
	private final int MAX_PAID_CREDITS = 12;
	private final int MAX_POSSIBLE_FEE = 3450;
	
	
	//constructor
	public DegreeStudent(String first_name, String last_name, int student_id, 
			int student_age, int credits_enrolled, Major major, AcademicStanding academic_standing) 
	{
		super(first_name, last_name, student_id, student_age, credits_enrolled);
		
		this.major = major;
		this.academic_standing = academic_standing;
	}
	
	//Getters
	public int getRecreationFee() {
		return RECREATION_FEE;
	}
	
	public int getStudentUnionFee() {
		return STUDENT_UNION_FEE;
	}
	
	public int getCostPerCredit() {
		return CREDIT_FEE;
	}
	
	public int getMaxPaidCredits() {
		return MAX_PAID_CREDITS;
	}
	
	public int getMaxFee() {
		return MAX_POSSIBLE_FEE;
	}
	
	public Major getMajor() {
		return major;
	}
	
	public AcademicStanding getAcademicStanding() {
		return academic_standing;
	}
	
	public void printData() {
		super.printData();
		System.out.println();
		System.out.println(getFirstName() + " is a degree-seeking student enrolled in " + getCreditsEnrolled() + " credits");
	}
}

