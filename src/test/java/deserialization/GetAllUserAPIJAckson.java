package deserialization;

import static io.restassured.RestAssured.given;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAllUserAPIJAckson {
	
	@Test
	public void getAllUsersTest()
	{
		
		RestAssured.baseURI="https://gorest.co.in/";
		
		Response response= given()
		          .header("Authorization","Bearer 3ed6cb82d26fe02fa8bee6143b2d78b6a0b777d9ff192dcb18a6486f1613997a")
		          .when()
		          .get("/public/v2/users");
		   
		//response.prettyPrint();
		
		ObjectMapper mapper=new ObjectMapper();
		
		try {
			User[] userRes=mapper.readValue(response.getBody().asString(), User[].class);
			
			System.out.println(userRes);
			
			for(User temp:userRes)
			{
				System.out.println(temp);
			}
			
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
