package createuserwithpojoandlambok;

import org.apache.commons.lang3.RandomStringUtils;

public class UserObjectCreation {

	public static void main(String[] args) {
		
		String randomEmail = RandomStringUtils.randomAlphanumeric(8).toLowerCase() + "@flm.org";
		User obj1=new User("santosh", randomEmail, "male", "inactive");
		//System.out.println
		//("name:"+obj1.getName()+" email : "+obj1.getEmail()+" gender :"+obj1.getGender()+" status "+obj1.getStatus());
		
		System.out.println(obj1);
	
	}

}
