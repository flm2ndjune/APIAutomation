package apitestswithbdd;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortString {
	
	public static void main(String[] args) {
		
		
		String[] str= {"cat","bat","rat","mat","hat"};
		
		List<String> allStrings= Arrays.asList(str);
		
		Collections.sort(allStrings);
		
		System.out.println(allStrings);
		
		
		
		
	}

}
