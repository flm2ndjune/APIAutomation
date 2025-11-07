package apitestswithbdd;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GoRestAPITest {
	

	@Test
	public void createUserTest2() throws IOException
	{
		
		RestAssured.baseURI="https://gorest.co.in";
		
		//FileInputStream fis1=new FileInputStream("src\\test\\resources\\testdata\\jsons\\user.json");
		
		String rawData=new String(Files.readAllBytes(Paths.get("src\\test\\resources\\testdata\\jsons\\user.json")));
		
		System.out.println(rawData);
		
		 String randomEmail = RandomStringUtils.randomAlphanumeric(8).toLowerCase() + "@flm.org";
		 
		 String updatedData=rawData.replace("{{email}}", randomEmail);
		 
		  given()
          .header("Authorization","Bearer 3ed6cb82d26fe02fa8bee6143b2d78b6a0b777d9ff192dcb18a6486f1613997a")
          .contentType(ContentType.JSON)
          .body(updatedData)
          .when()
          .post("/public/v2/users")
          .then().log().all()
          .assertThat()
          .statusCode(201);
		 
		        
	}
	
	
	
	@Test(enabled = false)
	public void createUserTest() throws FileNotFoundException
	{
		
		RestAssured.baseURI="https://gorest.co.in";
		
		FileInputStream fis1=new FileInputStream("src\\test\\resources\\testdata\\jsons\\user.json");
		
	      given()
		          .header("Authorization","Bearer 3ed6cb82d26fe02fa8bee6143b2d78b6a0b777d9ff192dcb18a6486f1613997a")
		          .contentType(ContentType.JSON)
		          .body(fis1)
		          .when()
		          .post("/public/v2/users")
		          .then().log().all()
		          .assertThat()
		          .statusCode(201);
		        
	}
	
	@Test(enabled = false)
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
