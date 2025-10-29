package apitestswithbdd;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class ContactsAPITests {
	
	@BeforeMethod
	public void setUp()
	{
		RestAssured.baseURI="https://thinking-tester-contact-list.herokuapp.com";
	}
	
	@Test
	public void getContactsAPITest()
	{
		
		
		given().log().all()
		   .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2OGZmODRlYzgxNjM2MzAwMTU1NjcxZTUiLCJpYXQiOjE3NjE3NTA0Mzh9.7p_yP7eb8Y4sMdrNZmmG9-GQZdQP2_6S1Ic0pzfHoCs")
		     .when()
		        .get("/contacts")
		         .then().log().all()
		         .assertThat()
		           .statusCode(200)
		            .and()
		             .contentType(ContentType.JSON);
		            
		          
		
	}
	
	@Test
	public void getContactsAPIAuthErroTest()
	{
		
		
		given().log().all()
		   .header("Authorization", "Bearer reyaz")
		     .when()
		        .get("/contacts")
		         .then().log().all()
		         .assertThat()
		           .statusCode(401);
		            
		          
		
	}

}
