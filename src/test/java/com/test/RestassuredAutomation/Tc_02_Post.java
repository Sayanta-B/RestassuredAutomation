package com.test.RestassuredAutomation;

import static org.testng.Assert.assertEquals;

import org.apache.poi.xssf.model.ThemesTable.ThemeElement;
import org.codehaus.groovy.transform.EqualsAndHashCodeASTTransformation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Tc_02_Post {
	
	@Test
	public void postRequest() {
		
		String payload="{\"name\":\"morpheus\",\"job\":\"leader\"}";
		
		Response response=RestAssured
				.given()
				.auth().none()
				.contentType(ContentType.JSON)
				.when()
//				.body(payload).log().all()
				.body(payload)
				.post("https://reqres.in/api/users");
		int Statuscode=response.statusCode();
		System.out.println(Statuscode);
		System.out.println(response.getHeaders());
		
		System.out.println(response.getHeader("Etag"));
//		System.out.println(response.getCookie());
		System.out.println(response.getContentType());
		Assert.assertEquals(Statuscode, 201);
		Assert.assertEquals(response.getBody().path("name"), "morpheus");
		Assert.assertEquals(response.getBody().path("job"), "leader");
		Assert.assertEquals(response.jsonPath().get("job"), "leader");
		
	}
//	@Test
//	public void postRequest2() {
//		
//		String payload="{\"name\":\"morpheus\",\"job\":\"leader\"}";
//		
//		RestAssured
//				.given()
//				.auth().none()
//				.contentType(ContentType.JSON)
//				.when()
//				.body(payload)
//				.post("https://reqres.in/api/users")
//				.then().log().all()
//				.body("name",equals("morpheus"));
//		
//		
//		
//	}

}
