
package com.creatio.crm.api.stepDefinitions;

import com.creatio.crm.api.pages.APIPage;
import com.creatio.crm.framework.api.commons.APICommons;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApiStepDefinitons {
	
	static String repoName;
	static String repoDescription;
	
	@Given("User sets the repository name as {string} and description as {string}")
	public void setRepositoryNameAndDescription(String name,String desc) {
		repoName =name;
		repoDescription=desc;
	}
	
	//Post
	@When("User sends a {string} request with end point {string} to create the repository with visibility {string}")
	public void userSendsRequestToCreateRepo(String method, String endPoint, String visibility) {
		String requestBody= APIPage.createRequestBody(repoName, repoDescription, visibility);
				System.out.println("Request Body:" +requestBody);
				APICommons.getResponse(method, endPoint, requestBody);
	}
	
	@Then("User should get the response code as {int}")
	public void verifyResponseCode(int expectedStatusCode) {
		APICommons.validateStatusCode(expectedStatusCode);
	}
	
	@And("User should get the response message as {string}")
	public void verifyResponseMessage(String expectedResponseMsg) {
		APICommons.validateStatusMessage(expectedResponseMsg);
	}
	
	@And("User should get the response within {int} seconds")
	public void verifyResponseTime(int seconds) {
		APICommons.validateResponseTime(seconds);
	}
	
	@And("Response body should contain {string} with value {string}")
	public void verifyResponseBody(String key,String value) {
		APICommons.validateResponseBody(key, value);
	}
	
	//Get
	@Given("User sends a {string} request with endpoint {string} to get the repo")
	public void userSendsRequestToGetRepo(String method, String endPoint) {
		APICommons.getResponse(method, endPoint, null);
	}
	
	//Patch
	 @Given("User sends a {string} request with endpoint {string} to update the repo visibility {string}")
	 public void userPatchRequestToUpdateVisibilty(String method, String endpoint, String visibility) {
		 String requestBody=APIPage.updateRepoRequestBody(visibility);
		 System.out.println("RequestBody :"+requestBody);
		 APICommons.getResponse(method, endpoint, visibility);
	 }
	 
	 //Delete
	@ Given("User sends a {string} request with endpoint {string} to delete the repo")
	public void userDeleteRequest(String method, String endpoint) {
		APICommons.getResponse(method, endpoint, null);
	}
}
