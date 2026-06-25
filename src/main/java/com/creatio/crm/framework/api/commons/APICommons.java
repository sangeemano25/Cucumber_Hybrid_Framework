package com.creatio.crm.framework.api.commons;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;

import com.creatio.crm.framework.utilities.PropUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APICommons {
//This contains all common methods related to API Integrations
	
	public static Response response = null;
	public static Properties prop = PropUtil.readData("config.properties");
	
	//common method to get response by providing endpoint, request type and request body
	public static void getResponse(String requestType, String endPoint, String requestBody) {
		RestAssured.baseURI= prop.getProperty("api.baseurl");
		String token= prop.getProperty("git.token");
		
		switch(requestType.toUpperCase()){
			case "GET":
				response=RestAssured.given().headers("Authorization",token).headers("Content-Type","application/vnd.github+json").when().get(endPoint);
				break;
			case "POST":
				response=RestAssured.given().headers("Authorization",token).headers("Content-Type","application/vnd.github+json").body(requestBody).when().post(endPoint);
				break;
			case "PUT":
				response=RestAssured.given().headers("Authorization",token).headers("Content-Type","application/vnd.github+json").body(requestBody).when().put(endPoint);
				break;
			case "PATCH":
				response=RestAssured.given().headers("Authorization",token).headers("Content-Type","application/vnd.github+json").body(requestBody).when().patch(endPoint);
				break;
			case "DELETE":
				response=RestAssured.given().headers("Authorization",token).headers("Content-Type","application/vnd.github+json").when().delete(endPoint);
				break;
			}
		wait(2);
		System.out.println(response.getBody().asPrettyString()); //prettystring -displays o/p in same format as in postman tool
		}
		
	//common method for wait time
	public static void wait(int seconds) {
		try {
		Thread.sleep(seconds*1000);
	    }catch(InterruptedException e) {
		e.printStackTrace();
	    }
	}
	
	//common method to validate status code from response
	public static void validateStatusCode(int expectedStatusCode) {
		int actualStatusCode=response.getStatusCode();
		Assert.assertEquals(actualStatusCode, expectedStatusCode,"Status Code not matching");
	}
	
	//common method to validate status message from response
	public static void validateStatusMessage(String expectedStatusMsg) {
		String actualStatusMsg = response.getStatusLine();
		Assert.assertTrue(actualStatusMsg.contains(expectedStatusMsg), "Status message not matching");
	}
	
	//common method to validate response time from response
	public static void validateResponseTime(long expectedResponseTime) {
		long actualResponseTime = response.getTimeIn(TimeUnit.SECONDS);
		Assert.assertTrue(actualResponseTime<=expectedResponseTime, "Response Time exceeded");
	}
	
	//common method to validate response body w.r.t key
	public static void validateResponseBody(String key, String expectedValue) {
		String actualVaue = response.jsonPath().getString(key);
		Assert.assertEquals(actualVaue,expectedValue, "Response body value is incorrect");
	}
	
	//common method to validate header value w.r.t header key
		public static void validateResponseHeader(String key, String expectedValue) {
			String actualVaue = response.getHeader(key);
			Assert.assertEquals(actualVaue,expectedValue, "Response header value is incorrect");
		}
		
	
}