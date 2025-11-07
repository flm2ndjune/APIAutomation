package apitestswithbdd;

public class StringSplitMEthod {

	//a=97
	//A=65
	public static void main(String[] args) {

		String emailId1="john@example.com";
		String emailId2="jane.doe@company.org";
		String emailId3="info@site.net";
		String emailId4 = "wobirab239@haotuwu.com";

		String[] parts1 = emailId1.split("[@.]");
		String[] parts2 = emailId2.split("[@.]");
		String[] parts3 = emailId3.split("[@.]");
		String[] parts4 = emailId4.split("[@.]");
		

		for (int i = 0; i < parts1.length; i++) {
			System.out.print(parts1[i]+"\t");
		}
		System.out.println();
		for (int i = 0; i < parts2.length; i++) {
			System.out.print(parts2[i]+"\t");
		}
		System.out.println();
		for (int i = 0; i < parts3.length; i++) {
			System.out.print(parts3[i]+"\t");
		}
		System.out.println();
		for (int i = 0; i < parts4.length; i++) {
			System.out.print(parts4[i]+"\t");
		}
		System.out.println();
		
	}

}
