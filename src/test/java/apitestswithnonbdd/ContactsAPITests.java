package apitestswithnonbdd;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ContactsAPITests {
	
	@Test
	public void getContactsTests()
	{
		
		RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
		
		RequestSpecification request=RestAssured.given();
		
		request.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2OGZmODRlYzgxNjM2MzAwMTU1NjcxZTUiLCJpYXQiOjE3NjE3NTA0Mzh9.7p_yP7eb8Y4sMdrNZmmG9-GQZdQP2_6S1Ic0pzfHoCs");
		
		Response  response=request.get("/contacts");
		
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
		System.out.println(response.time());
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertTrue(response.time()<6000);
		
		
		response.prettyPrint();
		
		
		
		
	}

}
