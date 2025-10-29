package apitestswithbdd;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class ContactsAPITests2 {
	
	RequestSpecification rs;
	@BeforeMethod
	public void setUp()
	{
		RestAssured.baseURI="https://thinking-tester-contact-list.herokuapp.com";
		
		rs=given().log().all()
		   .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2OGZmODRlYzgxNjM2MzAwMTU1NjcxZTUiLCJpYXQiOjE3NjE3NTA0Mzh9.7p_yP7eb8Y4sMdrNZmmG9-GQZdQP2_6S1Ic0pzfHoCs");
	}
	
	@Test
	public void getContactsAPITest()
	{
		
		
	  rs.when()
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
		
		
		rs
		     .when()
		        .get("/contacts")
		         .then().log().all()
		         .assertThat()
		           .statusCode(200);
		            
		          
		
	}

}
