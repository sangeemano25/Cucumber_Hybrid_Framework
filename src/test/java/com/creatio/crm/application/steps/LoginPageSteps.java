package com.creatio.crm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.creatio.crm.application.elements.LoginPageElements;

public class LoginPageSteps extends LoginPageElements {
	//This class will contain all the methods related to the login page of the application
	
	public LoginPageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Method to verify that the login page is displayed
	public void verifyLoginPageIsDisplayed() {
		waitForElement(loginPageHeader);
		//log("info", "Login page is displayed");		
	}
	
	//Method to enter business email and password
	public void enterBusinessEmailAndPassword(String email, String password) {
		
		waitForElement(emailInputField);
		enterText(emailInputField, email);
		waitForElement(passwordInputField);
		enterText(passwordInputField, password);
		//log("info", "Entered business email and password successfully");
	}
	//Method to enter business mail
public void enterBusinessEmail(String email) {
		
		waitForElement(emailInputField);
		enterText(emailInputField, email);
}
	//Method to click on the login button
	public void clickOnLoginButton() {
		waitForElement(loginButton);
		click(loginButton);
		//log("info", "Clicked on login button successfully");
	}
	
	//Method to click on the forgot password link
	public void clickOnForgotPasswordLink() {
		waitForElement(forgotPasswordLink);
		click(forgotPasswordLink);
		//log("info", "Clicked on forgot password link successfully");
	}
	
	//Method to verify that the reset password confirmation message is displayed
	public void verifyResetPasswordConfirmationMessageIsDisplayed() {
		waitForElement(resetPasswordConfirmation);
		//log("info", "Reset password confirmation message is displayed");
	}
	
	//Method to click on sign-up link
	public void clickOnSignUpLink() {
		waitForElement(signUpLink);
		click(signUpLink);
		//log("info", "Clicked on sign-up link successfully");
		
	}
}
