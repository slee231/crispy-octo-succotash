package restAssuredTests;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredGet {
	
	
	@Test
	public void getMethodTest() {
		
		// set the base URL
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		
		// create request object
		RequestSpecification httpRequest = RestAssured.given();
		
		// response object
		Response myResponse = httpRequest.request(Method.GET);
		
//		// print#1
//		System.out.println("This is the PRINT#1 Message: " + myResponse.getBody().asString());
//		
//		// print#2
//		System.out.println("This is the PRINT#2 Message: " + myResponse.then().log().all());
//		
//		// print#3
//		System.out.println("PRINT#3 " + myResponse.prettyPrint());
		
		// validate status code
		System.out.println("Status code is : ======= " + myResponse.getStatusCode());
		
		Assert.assertEquals(200, myResponse.getStatusCode());
		
		System.out.println("it's a pass");
		
		
		
		
	}
	

}
