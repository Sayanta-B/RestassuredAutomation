package com.test.RestassuredAutomation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TC_GitHUbPost {
	
	@Test
	public void gitHubPost() {
		
		
		String payload="{\r\n" + 
				"        \"name\": \"blog_Auto2\",\r\n" + 
				"        \"auto_init\": true,\r\n" + 
				"        \"private\": true,\r\n" + 
				"        \"gitignore_template\": \"nanoc\"\r\n" + 
				"      }";
		
		Response response= RestAssured.
				
				given().baseUri("https://api.github.com/").basePath("user/repos")
				
				.contentType(ContentType.JSON)
				.auth().oauth2("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")
				.when().body(payload).post().andReturn();
		
		System.out.println(response.prettyPrint());
		System.out.println(response.statusCode());
	}

}
