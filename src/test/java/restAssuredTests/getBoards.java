package restAssuredTests;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getBoards {
	
	String APIKey = "c157d01a72491fb522fbbc4b77271da9";
	String OAuthToken = "ATTAa686dcdd2b9ea5ce8aeb9bd6667d7e726af8d17e2e0e746b56c18a434273b0b50B1F7B6F";
	
	
	@Test
	public void getBoards() {
		
		// set the base URL
		RestAssured.baseURI = "https://api.trello.com/1/members/me/boards";
		
		// create request object
		RequestSpecification httpRequest = RestAssured.given();
		
		Response myResponse = httpRequest.get(RestAssured.baseURI + "?key=" + APIKey + "&token=" + OAuthToken);
		
		System.out.println(myResponse.prettyPrint());
		
		Assert.assertEquals(200, myResponse.getStatusCode());
		
	}
}
