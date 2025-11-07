package apitestswithnonbdd;

import java.util.HashMap;

import org.testng.annotations.Test;

import static  io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GoRestAPITests {
	
	@Test(enabled = false)
	public void getAllUsersWithQueryParam()
	{
		
		
		RestAssured.baseURI = "https://gorest.co.in";
		
			
		Response response = given()
	            .basePath("/public/v2/users")               
	            .header("Authorization", "Bearer 5968dcc472361380ed8587436d7934523708c1c9bd1320348e2aa93fbd4a035a") // Token
	            .header("Content-Type", "application/json")
	            .queryParam("status", "inactive")
	            .queryParam("gender", "female")
	        .when()
	            .get()                                  
	        .then()
	            .statusCode(200)                           
	            .extract().response();                      

		response.prettyPrint();
		
	}
	
	
	@Test(enabled = true)
	public void getAllUsersWithQueryParamAsMap()
	{
		
		
		RestAssured.baseURI = "https://gorest.co.in";
		
		HashMap<String, String> params=new HashMap<String, String>();
		params.put("status", "active");
		params.put("gender", "male");
			
		Response response = given()
	            .basePath("/public/v2/users")               
	            .header("Authorization", "Bearer 5968dcc472361380ed8587436d7934523708c1c9bd1320348e2aa93fbd4a035a") // Token
	            .header("Content-Type", "application/json")
	            .queryParams(params)
	        .when()
	            .get()                                  
	        .then()
	            .statusCode(200)                           
	            .extract().response();                      

		response.prettyPrint();
		
	}

}
