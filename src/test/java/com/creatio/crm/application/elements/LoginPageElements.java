package com.creatio.crm.application.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.creatio.crm.framework.web.commons.WebCommons;

public class LoginPageElements extends WebCommons {
	//This class will contain all the elements present on the login page of the application
	
	@FindBy(xpath ="//span[text()='LOG IN TO YOUR ACCOUNT']")
	public WebElement loginPageHeader;
	
	@FindBy(xpath="//input[@aria-label='Business email']")
	public WebElement emailInputField;
	
	@FindBy(xpath="//input[@aria-label='Password']")
	public WebElement passwordInputField;
	
	@FindBy(xpath="//span[text()=' LOG IN ']")
	public WebElement loginButton;
	
	@FindBy(xpath="//img[@class='icon-LinkedIn']")
	public WebElement linkedInLogo;
	
	@FindBy(xpath="//img[@class='icon-google']']")
	public WebElement googleLogo;
	
	@FindBy(xpath="//span[text()='Don’t have an account?']")
	public WebElement signUpHeader;
	
	@FindBy(xpath="//span[text()=' SIGN UP ']")
	public WebElement signUpLink;
	
	@FindBy(xpath="//a[text()='Forgot password']")
	public WebElement forgotPasswordLink;
	
	@FindBy(xpath="//div[@class='reset-password-confirmation-alm]")
	public WebElement resetPasswordConfirmation;
	
}
