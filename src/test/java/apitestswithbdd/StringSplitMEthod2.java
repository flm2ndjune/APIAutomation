package apitestswithbdd;

public class StringSplitMEthod2 {

	public static void main(String[] args) {

		String[] emailIds= {"john@example.com","jane.doe@company.org","info@site.net","wobirab239@haotuwu.com"};
		
		for(int i=0;i<emailIds.length;i++)
		{
			String[] parts=emailIds[i].split("[@.]");
			for(int j=0;j<parts.length;j++)
			{
				System.out.print(parts[j]+"\t");
			}
			System.out.println();
		}
		
		
		
		
		

	

		
	}

}
