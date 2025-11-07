package createuserapi;

import static io.restassured.RestAssured.given;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateUserJson {
	
	
	@Test
	public void createUSerJSON()
	{
			RestAssured.baseURI="https://gorest.co.in";
		
		//FileInputStream fis1=new FileInputStream("src\\test\\resources\\testdata\\jsons\\user.json");
		
		
		 
		  given()
          .header("Authorization","Bearer 3ed6cb82d26fe02fa8bee6143b2d78b6a0b777d9ff192dcb18a6486f1613997a")
          .contentType(ContentType.JSON)
          .body("{\r\n"
          		+ "	\r\n"
          		+ "	\"name\": \"ramesh\",\r\n"
          		+ "	\"gender\": \"male\",\r\n"
          		+ "	\"email\": \"abcd03112025@gmail.com\",\r\n"
          		+ "	\"status\": \"active\"\r\n"
          		+ "	\r\n"
          		+ "}")
          .when()
          .post("/public/v2/users")
          .then().log().all()
          .assertThat()
          .statusCode(201);
	}

}
