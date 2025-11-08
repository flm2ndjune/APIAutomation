package getcallwithdeserialization;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetUserTest {
	
	@Test
	public void getSingleUserTest()
	{
		
		RestAssured.baseURI="https://gorest.co.in";
		
		Response response= given()
		          .header("Authorization","Bearer 3ed6cb82d26fe02fa8bee6143b2d78b6a0b777d9ff192dcb18a6486f1613997a")		         
		          .when()
		          .get("public/v2/users/8227518");
		
		
		response.prettyPrint();
		
	}

}
