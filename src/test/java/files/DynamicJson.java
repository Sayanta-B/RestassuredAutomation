package files;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import  io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynamicJson{
	
	@Test
	public static void addBook() {
		RestAssured.baseURI="http://216.10.245.166";
		String response=given().header("Content-Type","application/json")
		.body(Payloads.addBook())
		.post("Library/Addbook.php")
		.then().assertThat().statusCode(200)
		.extract().response().asString();
		
		JsonPath js=ReUsableMethods.rawToJson(response);
		System.out.println(js.getString("ID"));
	}
//	public static void main(String[] args) {
//		addBook();
//	}

}
