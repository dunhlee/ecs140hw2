package hw2;

public enum Major {
	GAMING_SCIENCE("S", "gaming science"),
	HOTEL_MANAGEMENT("M", "hotel management"), 
	LOUNGE_ARTS("A", "lounge arts"),
	BEVERAGE_ENGINEERING("E", "beverage engineering");
	
	private String code;
	private String displayMajor;
	
	Major(String code, String displayMajor) {
		this.code = code;
		this.displayMajor = displayMajor;
	}
	
	public String displayMajor() {
		return displayMajor;
	}
	
	public String getCode() {
		return code;
	}
	
	public static Major setMajorWithCode(String code) {

		for (Major major: Major.values()) {
			if (major.code.equals(code)) {
				return major;
			}
		}
		
		throw new IllegalArgumentException("Unknown Major Code: " + code);
	}
}
