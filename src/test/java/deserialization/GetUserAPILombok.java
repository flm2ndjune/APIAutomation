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

public class GetUserAPILombok {
	
	@Test
	public void getSingleUserTest()
	{
		String randomEmail = RandomStringUtils.randomAlphanumeric(8).toLowerCase() + "@flm.org";
		
		
		UserLombok user=new UserLombok.UserLombokBuilder()
		        .name("chandra")
		        .email(randomEmail)
		        .status("active")
		        .gender("male")
		        .build();
		
		RestAssured.baseURI="https://gorest.co.in/";
		
		Integer userID=given()
		           .header("Authorization","Bearer 3ed6cb82d26fe02fa8bee6143b2d78b6a0b777d9ff192dcb18a6486f1613997a")
		           .contentType(ContentType.JSON)
		           .body(user)
		 .when()
		            .post("/public/v2/users")
		 .then()
		          .statusCode(201)
		          .extract()
		          .path("id");
		
			
		
		
		Response response= given()
		          .header("Authorization","Bearer 3ed6cb82d26fe02fa8bee6143b2d78b6a0b777d9ff192dcb18a6486f1613997a")		         
		          .when()
		          .get("public/v2/users/"+userID);
		
		
		response.prettyPrint();
		
		ObjectMapper mapper=new ObjectMapper();
		
		try {
			UserLombok userResponse=mapper.readValue(response.getBody().asString(), UserLombok.class);
			
			System.out.println(userResponse);
			
			Assert.assertEquals(userResponse.getName(), "chandra");
			Assert.assertEquals(userResponse.getEmail(), randomEmail);
			Assert.assertEquals(userResponse.getStatus(), "active");
			Assert.assertEquals(userResponse.getId(), userID);
			
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
