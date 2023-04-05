package restAssuredTests;

import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class postTest {
	
	
	@Test
	public void restAssuredPost() {
		
		// set the base URL
		RestAssured.baseURI = "https://reqres.in/api/users";
		
		// create request object
		RequestSpecification httpRequest = RestAssured.given();
		
		JSONObject myJson = new JSONObject();
		
		myJson.put("page", 22);
		myJson.put("per_page", 5);
		myJson.put("total", 10);
		myJson.put("total_pages", 5);
		
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(myJson.toJSONString());
		
		
		
		Response myResponse = httpRequest.request(Method.POST);
		
		int statusCode = myResponse.getStatusCode();
		
		System.out.println(statusCode);
		
		myResponse.prettyPrint();
		
	}

}
