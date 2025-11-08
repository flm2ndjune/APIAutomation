package createuserwithpojoandlambok;

public class UserObjectLombokCreation {

	public static void main(String[] args) {
		
		UserLombok user=new UserLombok("santosh","abcd0711@gmail.com","gender","active");
		
		System.out.println(user);
		
		System.out.println(user.getName());
		System.out.println(user.getEmail());
		System.out.println(user.getGender());
		System.out.println(user.getStatus());

	}

}
