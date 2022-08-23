package com.test.RestassuredAutomation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TC_GitHubPatch {
	
	@Test
	public void gitHubPatch() {
		
		
		String payload="{\r\n" + 
				"        \"name\": \"blog_Auto1\",\r\n" + 
				"        \"auto_init\": true,\r\n" + 
				"        \"private\": false,\r\n" + 
				"        \"gitignore_template\": \"nanoc\"\r\n" + 
				"      }";
		
		Response response= RestAssured.
				
				given().baseUri("https://api.github.com/repos/Sayanta-B/blog_Auto2")
				.contentType(ContentType.JSON)
				.auth().oauth2("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")
				.when().body(payload).patch().andReturn();
		
		System.out.println(response.prettyPrint());
		System.out.println(response.statusCode());
	}

}
