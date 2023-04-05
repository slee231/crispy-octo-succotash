package restAssuredTests;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class createBoards {
	
	String APIKey = "c157d01a72491fb522fbbc4b77271da9";
	String OAuthToken = "ATTAa686dcdd2b9ea5ce8aeb9bd6667d7e726af8d17e2e0e746b56c18a434273b0b50B1F7B6F";
	String boardName = "restAssuredBoard";
	
	
	@Test
	public void createBoard() {
		
		
		// set the base URL
		RestAssured.baseURI = "https://api.trello.com/1/boards";
		
		// create request object
		RequestSpecification httpRequest = RestAssured.given();
		
		httpRequest.header("Content-Type", "application/json");
		
		Response myResponse = httpRequest.post(RestAssured.baseURI+"/?name="+boardName+"&key="+APIKey+"&token="+OAuthToken);
		
		int statusCode = myResponse.getStatusCode();
		
		Assert.assertEquals(200, statusCode);
		
		System.out.println("The test passed and board created with status code- " + statusCode);
		
		
		
	}

}
