package createuserwithpojoandlambok;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateUserTestWithLombokBuilder {
	
	@Test
	public void createUserTest()
	{
		
		String randomEmail = RandomStringUtils.randomAlphanumeric(8).toLowerCase() + "@flm.org";
		
		//UserLombok user=new UserLombok("santosh",randomEmail,"male","active");
		
		//builder pattern using lombok
		UserLombok user=new UserLombok.UserLombokBuilder()
		        .name("chandra")
		        .email(randomEmail)
		        .status("active")
		        .gender("male")
		        .build();
		
		RestAssured.baseURI="https://gorest.co.in/";
		
		Integer userID=given().log().all()
		           .header("Authorization","Bearer 3ed6cb82d26fe02fa8bee6143b2d78b6a0b777d9ff192dcb18a6486f1613997a")
		           .contentType(ContentType.JSON)
		           .body(user)
		 .when()
		            .post("/public/v2/users")
		 .then().log().all()
		          .statusCode(201)
		          .extract()
		          .path("id");
		
		System.out.println("user id : "+userID);
		
		
	}

}
