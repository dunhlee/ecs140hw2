package hw2;

public class DegreeStudentWithAid extends DegreeStudent {
	private int financial_aid;
	
	//constructor
	public DegreeStudentWithAid(String first_name, String last_name, 
			int student_id, int student_age, int credits_enrolled, Major major, AcademicStanding academic_standing, int financial_aid)
	{
		super(first_name, last_name, student_id, student_age, credits_enrolled, major, academic_standing);
		this.financial_aid = financial_aid;
	}
	
	//Getter
	public int getFinancialAid() {
		return financial_aid;
	}
	
	public void printData() {
		super.printData();
		System.out.println(getFirstName() + " receives $" + getFinancialAid() + " in financial assistance per term");
		System.out.println(getFirstName() + "'s major is " + getMajor().displayMajor());
		System.out.println(getFirstName() + "'s academic standing is " + getAcademicStanding().displayStanding());
	}
	
	public int computeFees() {
		if (getCreditsEnrolled() >= getMaxPaidCredits()) {
			if (getMaxFee() - getFinancialAid() < 0) {
				return 0;
			} else {
				return getMaxFee() - getFinancialAid();
			}
		}
		
		int computed_fees = getRecreationFee() + getStudentUnionFee();
		computed_fees += getCreditsEnrolled() * getCostPerCredit();
		
		if (computed_fees - getFinancialAid() < 0) {
			return 0;
		}
		
		return computed_fees - getFinancialAid();
	}
}
