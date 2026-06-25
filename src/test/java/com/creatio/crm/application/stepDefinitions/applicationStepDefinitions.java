package com.creatio.crm.application.stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import com.creatio.crm.application.steps.CookiesPageSteps;
import com.creatio.crm.application.steps.HomePageSteps;
import com.creatio.crm.application.steps.LoginPageSteps;
import com.creatio.crm.application.steps.SignUpPageSteps;
import com.creatio.crm.framework.base.BasePage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class applicationStepDefinitions {
	public LoginPageSteps loginPage;
	public CookiesPageSteps cookiesPage;
	public HomePageSteps homePage;
	public SignUpPageSteps signUpPage;
	
	//Meaning the below method will always create object and provide driver only when browser is launched
	@Given("Initialize the page objects")
	public void initializePages() {		
		WebDriver driver = BasePage.getDriver();
		loginPage = new LoginPageSteps(driver);
		cookiesPage = new CookiesPageSteps(driver);
		homePage = new HomePageSteps(driver);
		signUpPage = new SignUpPageSteps(driver);
	}
	
	@Given("Launch the application")
	public void launchApplication() {
		loginPage.launchApplication();
	}
	
	@Then("Verify the cookies popup is displayed.")
	public void VerifyCookiesPopup() {
		cookiesPage.verifyCookiesPopupIsDisplayed();
	}
	
	@When("User select {string} button")
	public void userSelectButton(String button) {
		cookiesPage.clickOnSelectionButton(button);
	}
	
	@Then("Verify the cookies popup is closed.")
	public void verifyCookiesPopupClosed() {
		cookiesPage.verifyCookiesPopupIsClosed();
	}
	
	@And("Verify Login page is displayed")
	public void VerifyLoginPageDisplayed() {
	loginPage.verifyLoginPageIsDisplayed();	
	}
	
	@When("User click on the Sign-up link")
	public void userClickOnSignupLink() {
		loginPage.clickOnSignUpLink();
	}
	
	@Then("Verify the Sign-up page should be displayed.")
	public void verifySignUpPageDisplayed() {
		signUpPage.verifySignUpPageIsDisplayed();
	}
	@When("User enter valid business email {string}")
	public void userEnterValidBusinessEmail(String email) {
		loginPage.enterBusinessEmail("test@test.com");
	}
	
	@And("User click on the Forgot Password link")
	public void userClickOnForgotPasswordLink(){
		loginPage.clickOnForgotPasswordLink();
	}
	
	@Then("User should get reset password confirmation message")
	public void userGetResetPasswordMessage() {
	loginPage.verifyResetPasswordConfirmationMessageIsDisplayed();
	}
	
	@And("Social media links should be displayed within the login page")
	public void verifySocialMediaLinksDisplayed() {
	//loginPage.verifySocialMediaLinksIsDisplayed();
	}
	
	@When("^User enter (.*) and (.*)$")
	public void userEnterMailAndPassword(String email, String password) {
		loginPage.enterBusinessEmailAndPassword(email, password);
		
	}
	
	@And("User click on the Login button")
	public void userClickLoginButton() {
		loginPage.clickOnLoginButton();
		
	}

	@Then("Login should be successful")
	public void verifyLoginIsSuccessful() {
	    homePage.verifyHomePageIsDisplayed();
	}

	@When("User click on the user profile icon")
	public void userClickOnUserProfileIcon() {
	    homePage.clickOnUserProfileIcon();
	}

	@When("User select the Logout option")
	public void userSelectLogoutOption() {
	    homePage.clickOnLogoutButton();
	}

	@And("Validate the cookies pop-up content message")
	public void validateCookiesPopUpContentMessage(DataTable dataTable) {
	    List<Map<String, String>> cookiesContent = dataTable.asMaps(String.class, String.class);
	    String expectedMessage = cookiesContent.get(0).get("content");
	    cookiesPage.verifyCookiesPopupContentMessage(expectedMessage);
	}

	@Then("verify Cookies popup logos")
	public void verifyCookiesPopupLogos() {
	    cookiesPage.verifyCookiesPopupLogos();
	}
	
	@Then("Verify cookies pop-up selection buttons")
	public void verifyCookiesPopUpSelectionButtons() {
	    cookiesPage.verifyCookiesSelectionButtons();
	}

	@And("Verify cookies pop-up switch buttons")
	public void verifyCookiesPopUpSwitchButtons() {
	    cookiesPage.verifyCookiesSelectionSwitches();
	}

	@When("user clicks on Show Details Link")
	public void userClicksOnShowDetailsLink() {
	    cookiesPage.clickOnShowDetailsLink();
	}

	@Then("cookies pop-up should be displayed in expanded view")
	public void verifyCookiesPopUpExpandedView() {
	    cookiesPage.verifyCookiesPopupExpandedView();
	}

	@When("^User clicks on the (.*) button$")
	public void userClicksOnButton(String button) {
	    cookiesPage.clickOnSelectionButton(button);
	}

	@Then("cookies pop-up should get closed")
	public void verifyCookiesPopUpClosedAfterSelection() {
	    cookiesPage.verifyCookiesPopupIsClosed();
	}
}
