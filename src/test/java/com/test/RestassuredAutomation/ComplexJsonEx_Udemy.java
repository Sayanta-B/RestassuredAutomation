package com.test.RestassuredAutomation;

import java.util.PrimitiveIterator.OfDouble;

import files.ComplexJsonEx;
import io.restassured.path.json.JsonPath;

public class ComplexJsonEx_Udemy {

	public static void main(String[] args) {
		
		JsonPath jP=new JsonPath(ComplexJsonEx.complexJson());
		
		System.out.println(jP.get("dashboard.purchaseAmount"));
		
		int noOfCourses=jP.getInt("courses.size()");
		System.out.println(noOfCourses);
		
		//3. print title of the first course
		String titleOfFirstCourse=jP.get("courses[0].title");
		System.out.println(titleOfFirstCourse);
		
		//4. Print All course titles and their respective Prices
		
		for (int i=0;i<noOfCourses;i++) {
			
			String titleOfALLCourse=jP.get("courses["+i+"].title");
			System.out.println(titleOfALLCourse);
			System.out.println(jP.get("courses["+i+"].price"));
			
		}
		
		//5.Print no of copies sold by RPA Course
		
		for (int i=0;i<noOfCourses;i++) {
			String titleOfALLCourse=jP.get("courses["+i+"].title");
			
			if(titleOfALLCourse.equalsIgnoreCase("RPA")) {
				System.out.println(jP.getInt("courses["+i+"].copies"));
			}
					
				}

	}

}
