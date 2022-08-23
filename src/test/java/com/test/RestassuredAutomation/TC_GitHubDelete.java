package com.test.RestassuredAutomation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TC_GitHubDelete {
	
	@Test
	void deleteRepo() {
		RestAssured.baseURI = "https://api.github.com/";
		RestAssured.basePath = "repos/Sayanta-B/blog_Auto1";
		
		RestAssured
				.given()
//				.auth().basic("Sayanta-B","8sayanta8")
				.auth().oauth2("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")
				.when()
				.delete()
				.then()
				.log().all();

}
}
