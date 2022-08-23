package com.test.RestassuredAutomation;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import files.Payloads;
import groovy.json.JsonParser;

public class Basic_Udemy {

	public static void main(String[] args) {
		RestAssured.baseURI= "https://rahulshettyacademy.com";
		String response=
		given().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payloads.addPlaces()).
		when().post("/maps/api/place/add/json")
		.then().assertThat().log().all().statusCode(200).body("scope", equalTo("APP"))//validating
		.header("Server", "Apache/2.4.41 (Ubuntu)")//validating header
		.extract().response().asString(); //Extracting json value as string
		
		System.out.println(response);
		//parsing json response
		JsonPath jp = new JsonPath(response);
		String place_id=jp.getString("place_id");
		System.out.println(place_id);
		
		//----------------put--------------
		String newAddress="WestBengal, India";
		String putResponse=
				given().log().all().queryParam("key", "quick123").header("Content-Type","application/json")
				.body("{\r\n" + 
						"\"place_id\":\""+place_id+"\",\r\n" + 
						"\"address\":\""+newAddress+"\",\r\n" + 
						"\"key\":\"qaclick123\"\r\n" + 
						"}\r\n" + 
						"")
				.when().put("maps/api/place/update/json")
				.then().assertThat().log().all().statusCode(200).body("msg",equalTo("Address successfully updated")).extract().response().asString();
				JsonPath js2=new JsonPath(putResponse);
				String place_id1=js2.getString("place_id");
//Get New Address
				String getPlaceResponse= given().log().all().queryParam("key", "quick123").queryParam("place_id", place_id)
						
						.when().get("maps/api/place/get/json")
						.then().assertThat().log().all().statusCode(200).extract().response().asString();
				JsonPath js1=new JsonPath(getPlaceResponse);
				String actualAddress=js1.getString("address");
				System.out.println(actualAddress);
	}

}
