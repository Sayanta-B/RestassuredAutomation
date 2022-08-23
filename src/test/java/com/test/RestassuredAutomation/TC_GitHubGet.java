package com.test.RestassuredAutomation;

import org.apache.http.HttpRequest;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class TC_GitHubGet {
	@Test
	void getRepo() {
		RestAssured.baseURI = "https://api.github.com/";
		RestAssured.basePath = "users/Sayanta-B/repos";
		
		RestAssured
				.given()
				.when()
				.get()
				.then()
				.log().all();
		
//Response response= RestAssured.
//				
//				given()
//				.auth().oauth2("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")
//				.when().get().andReturn();
//System.out.println(response.prettyPrint());
//System.out.println(response.statusCode());


		
		
	}
	
	
}
