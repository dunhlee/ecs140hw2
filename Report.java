package hw2;
// TODO: Make sure you create a package named hw2 and add the package name to every Java file 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/*
 * To ensure you get graded correctly by autograder, 
 * DO NOT change the file name (Report.java), method name (generateReport), or add parameters to this method.
 * Fill in your code where there is a TODO comment.
 * Use the provided variables in the reportBuilder code. 
 * Check if your generateReport() output is equal to hw2_output.txt (String.equals())
 * 
 * Questions or comments? Direct them to Ty Feng or ask on Piazza
 * 
 */
public class Report {

	// generateReport() should be a public static method that takes no parameters and returns a String
	public static String generateReport() {
		StringBuilder reportBuilder = new StringBuilder();
		// TODO:
		// Read hw2.txt line by line
		// Hardcode "hw2.txt" as your input, which means that you should put hw2.txt 
		// right under your Eclipse workspace folder (the top level of the workspace hierarchy).

		// For each record, create an instance from the corresponding class (FinAssist,
		// NoFinAssist, Degree, etc.)

		// Save all instances to a Student[] array. Student is the interface or parent class for all the
		// classes you make.
		Student[] students = new Student[100]; // save all the student record objects here
		int student_count = 0;
		
		// DO NOT ADD, CHANGE, OR DELETE ANY reportBuilder code. Use the provided variables.
		// INDIVIDUAL REPORTS, listing of all students and the fees they have each been
		// assessed
		int student_fee = 0; // TODO: Change this! Assign its value in the iteration below and use the
								// provided print statement
		String student_name = ""; // TODO: Change this! Assign its value in the iteration below and use the
									// provided print statement
		
		// Print out first and last name and fee amount
		reportBuilder.append("Summary of each student's fees assessed: \n\n");
		
		try {
			Scanner scanner = new Scanner(new File("hw2.txt"));
			
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] student_data = line.split(";");
				
				int id = Integer.parseInt(student_data[0]);
				String first_name = student_data[1];
				String last_name = student_data[2];
				int age = Integer.parseInt(student_data[3]);
				int credits = Integer.parseInt(student_data[4]);
				String degree_status = student_data[5];
				
				//Logic for degree-seeking students
				if (degree_status.equals("Y")) {
					String major = student_data[6];
					String academic_status = student_data[7];
					String fin_aid_status = student_data[8];
					
					//if they have aid, then read and store that data and instantiate DegreeWithAid Student
					if (fin_aid_status.equals("Y")) {
						int fin_aid = Integer.parseInt(student_data[9]);
						students[student_count] = new DegreeStudentWithAid(first_name, last_name, id, age, credits,  
								Major.setMajorWithCode(major), AcademicStanding.setStandingWithCode(academic_status), fin_aid);
					} else { //Instantiate DegreeWithoutAid student
						students[student_count] = new DegreeStudentWithoutAid(first_name, last_name, id, age, credits, 
								Major.setMajorWithCode(major), AcademicStanding.setStandingWithCode(academic_status));
					}
				}
				
				//Logic for non-degree-seeking students
				if (degree_status.equals("N")) {
					String nondegree_status = student_data[6];
					
					//logic for certificate students
					if (nondegree_status.equals("C")) {
						String major = student_data[7];
						students[student_count] = new CertificateStudent(first_name, last_name, id, age, credits,
								Major.setMajorWithCode(major));
					} else {
						students[student_count] = new SeniorStudent(first_name, last_name, id, age, credits);
					}
				}
				
				student_name = students[student_count].getFirstName() + " " + students[student_count].getLastName();
				student_fee = students[student_count].computeFees();
				
				// TODO: iterate over all Student records and compute the individual student_fee. Assign student_name.
				// TODO: put the following line in your for/while loop so that every student's fee gets printed
				reportBuilder.append(student_name + " has $" + String.format("%,d", student_fee) + " fees assessed \n");
				
				student_count += 1;
			}
			
			
			scanner.close();
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}


		
		
		// This should work once your Student classes are implemented
		// Don't worry about the string formatting in printData()  :)
		// Make sure you do not comment out the following two lines when you submit the hw
		students[0].printData();
		students[1].printData();
		
		
		// SUMMARY REPORT of fees assessed for each of the four types of student
		int degree_nofin_fees = 0;
		int degree_fin_fees = 0;
		int certificate_fees = 0;
		int senior_fees = 0;
		int total_fees = 0;

		// TODO: Calculate the fees by iterating through all students, or do it in the loop above
		for (int i = 0; i < student_count; i++) {
			Student student = students[i];
			int fee = student.computeFees();
			
			if (student instanceof DegreeStudentWithoutAid) {
				degree_nofin_fees += fee;
				
			} else if (student instanceof DegreeStudentWithAid) {
				degree_fin_fees += fee;
				
			} else if (student instanceof CertificateStudent) {
				certificate_fees += fee;
				
			} else if (student instanceof SeniorStudent) {
				senior_fees += fee;
				
			}
		}
		
		total_fees += degree_nofin_fees + degree_fin_fees + certificate_fees + senior_fees;
		
		// Print out the total fees for different students
		reportBuilder.append("\n\n");
		reportBuilder.append("Summary of all student fees assessed: \n\n");
		reportBuilder.append(
				"Degree-seeking students without financial assistance: $" + String.format("%,d", degree_nofin_fees) + "\n");
		reportBuilder
				.append("Degree-seeking students with financial assistance: $" + String.format("%,d", degree_fin_fees) + "\n");
		reportBuilder.append("Certificate students: $" + String.format("%,d", certificate_fees) + "\n");
		reportBuilder.append("Senior citizens: $" + String.format("%,d", senior_fees) + "\n\n");
		reportBuilder.append("Total fees assessed: $" + String.format("%,d", total_fees));

		return reportBuilder.toString();
	}

	public static void main(String[] args) {
		// You may test your Report here by comparing the output with the provided hw2_output.txt
		System.out.println(generateReport());
	}
}
