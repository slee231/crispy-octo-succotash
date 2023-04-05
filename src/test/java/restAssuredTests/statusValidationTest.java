package restAssuredTests;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;


public class statusValidationTest {
	
	String APIKey = "c157d01a72491fb522fbbc4b77271da9";
	String OAuthToken = "ATTAa686dcdd2b9ea5ce8aeb9bd6667d7e726af8d17e2e0e746b56c18a434273b0b50B1F7B6F";
	
	
	@Test
	public void validateData() {
		
		RequestSpecification httpRequest = RestAssured.given();
		
		httpRequest.given()
		.param("key", APIKey)
		.param("token", OAuthToken)
		.get("https://api.trello.com/1/members/me/boards")
		.then()
		.statusCode(200)
		.body("name", hasItems("Cohort13_BoardFromAPI", "Cohort13_BoardFromAPI_2"))
		.body("id", hasItems("641baddc166e09db052ba55e"));
		
		
	}
	
	
	
	
}
