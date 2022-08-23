package com.test.RestassuredAutomation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_Get_Request {
	
	@Test
	void getWeatherDetails() {
		//Specify base uri
		
		RestAssured.baseURI="https://api.github.com";
		//Request object created
		RequestSpecification httprequest=RestAssured.given();
		
		//Response object 
		Response response = httprequest.request(Method.GET,"/");
		
		//print response in console window(response.getBody will give you json format so need to convert it in string)
		
		String responseBody=response.getBody().asString();
		
		System.out.println("Response body is:-" + responseBody);
		//Status code validation
		int Statuscode=response.getStatusCode();		
		System.out.println("Status code is"+ Statuscode);
		Assert.assertEquals(Statuscode, 200);
		
		//status line verification
		String statusline=response.getStatusLine();
		System.out.println("Status line is :"+statusline);
		Assert.assertEquals(statusline,"HTTP/1.1 200 OK");
	}

}
