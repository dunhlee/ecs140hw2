package hw2;

public enum AcademicStanding {
	GOOD("G", "good"),
	WARNING("W", "warning"),
	PROBATION("P", "probation");
	
	private String code;
	private String academic_standing;
	
	AcademicStanding(String code, String academic_standing) {
		this.code = code;
		this.academic_standing = academic_standing;
	}
	
	public String displayStanding() {
		return academic_standing;
	}
	
	public String getCode() {
		return code;
	}
	
	public static AcademicStanding setStandingWithCode(String code) {
		for (AcademicStanding standing: AcademicStanding.values()) {
			if (standing.code.equals(code)) {
				return standing;
			}
		}
		
		throw new IllegalArgumentException("Unknown Major Code: " + code);
	}
}
