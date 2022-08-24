package files;

import io.restassured.path.json.JsonPath;

public class ReUsableMethods {
	
	public static JsonPath rawToJson(String str) {
		
		
		JsonPath jp=new JsonPath(str);
		
		return jp;
	}

}
