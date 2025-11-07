package apitestswithbdd;

import org.slf4j.helpers.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import java.util.List;

public class FakeStoreAPITests {
	
	@Test
	public void getProductsTest()
	{
		
		RestAssured.baseURI="https://fakestoreapi.com";
		
		Response response= given()
		     .when()
		     .get("/products");
		
		System.out.println(response.statusCode());
		
		//response.prettyPrint();
		
		JsonPath  js=response.jsonPath();
		
		List<Integer> allIds= js.getList("id");
		System.out.println(allIds);
		
		List<Double> allPrices=js.getList("price");
		System.out.println(allPrices);
		
		List<Double>  allRates=js.getList("rating.rate");
		System.out.println(allRates);
		
		List<Integer>  allcounts=js.getList("rating.count");
		System.out.println(allcounts);
		
		for(int i=0;i<allIds.size();i++)
		{
			int id=allIds.get(i);
			Object price=allPrices.get(i);
			Object rate=allRates.get(i);
			int count=allcounts.get(i);
			
			System.out.println("Id: "+id+" price: "+price+" rate: "+rate+" count: "+count );
			
		}
		
	}
	
	@Test
	public void getProductsCountTest()
	{
		
		RestAssured.baseURI="https://fakestoreapi.com";
		
		get("/products")
		   .then()
		      .assertThat()
		       .statusCode(200)
		         .body("$.size()", equalTo(20));
		
	}

}
