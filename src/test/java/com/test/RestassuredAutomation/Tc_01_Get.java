package com.test.RestassuredAutomation;

import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.model.ThemesTable.ThemeElement;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Tc_01_Get {
	
	@Test
	public void getResponse () {
		
		Response response=RestAssured
				.given()
				.param("page", 2)
				.auth().none()
			
				.when().get("https://reqres.in/api/users");
			
				
		System.out.println(response.getTimeIn(TimeUnit.SECONDS));
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody().asString());
		
	}

}
