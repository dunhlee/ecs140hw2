package hw2;

public class DegreeStudentWithoutAid extends DegreeStudent {

	//constructor
	public DegreeStudentWithoutAid(String first_name, String last_name, 
			int student_id, int student_age, int credits_enrolled, Major major, AcademicStanding academic_standing)
	{
		super(first_name, last_name, student_id, student_age, credits_enrolled, major, academic_standing);
	}
	
	public void printData() {
		super.printData();
		System.out.println(getFirstName() + "'s major is " + getMajor().displayMajor());
		System.out.println(getFirstName() + "'s academic standing is " + getAcademicStanding().displayStanding());
	}
	
	public int computeFees() {
		if (getCreditsEnrolled() >= getMaxPaidCredits()) {
			return getMaxFee();
		}
		
		int computed_fees = getRecreationFee() + getStudentUnionFee();
		computed_fees += getCreditsEnrolled() * getCostPerCredit();
		
		return computed_fees;
	}
}
