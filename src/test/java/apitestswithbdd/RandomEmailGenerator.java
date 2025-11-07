package apitestswithbdd;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomEmailGenerator {
	
	 public static void main(String[] args) {
	        String randomEmail = RandomStringUtils.randomAlphanumeric(8).toLowerCase() + "@flm.org";
	        System.out.println(randomEmail);
	    }

}
