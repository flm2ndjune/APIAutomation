package apitestswithbdd;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GoRestAPITest {
	
	
	@Test
	public void deleteUserTest()
	{
		
		RestAssured.baseURI="https://gorest.co.in";
		
		Response response=given()
		          .header("Authorization","Bearer 3ed6cb82d26fe02fa8bee6143b2d78b6a0b777d9ff192dcb18a6486f1613997a")
		           .delete("/public/v2/users/8208156");
		            
		Assert.assertEquals(response.statusCode(), 204);
	}
	@Test(enabled = false)
	public void getAllUserTest()
	{
		
		RestAssured.baseURI="https://gorest.co.in";
		
		Response response=given().log().all()
		          .header("Authorization","Bearer 3ed6cb82d26fe02fa8bee6143b2d78b6a0b777d9ff192dcb18a6486f1613997a")
		           .get("/public/v2/users");
		
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
		Assert.assertEquals(response.statusCode(), 200);
		           
		response.prettyPrint();
		

		
		
		
		
	}

}
