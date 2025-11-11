package jsonpathjayway;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.Map;

public class FakeProductAPI {
	
	@Test
	public void getProductJsaonPathTest()
	{
		
		RestAssured.baseURI="https://fakestoreapi.com";
		
		Response response= given().when().get("/products");
		
		String jsonResponse=response.body().asString();
		
		System.out.println(jsonResponse);
		
		//response.prettyPrint();
		
	   ReadContext context=	JsonPath.parse(jsonResponse);
		
	  List<Integer> ids= context.read("$.[*].id");
	  System.out.println(ids);
	  
	  List<Map<String,Object>> allIdTitles=context.read("$.[*].['id','title']");
	  System.out.println(allIdTitles.size());
	  
	  for(Map<String,Object> temp:allIdTitles)
	  {
		  System.out.print(temp.get("id")+"\t");
		  System.out.println(temp.get("title"));
	  }
	  
	}

}
