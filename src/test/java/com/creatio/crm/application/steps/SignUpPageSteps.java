package com.creatio.crm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.creatio.crm.application.elements.SignUpPageElements;
import com.creatio.crm.framework.base.BasePage;

public class SignUpPageSteps extends SignUpPageElements{

	public SignUpPageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void verifySignUpPageIsDisplayed() {
		Assert.assertTrue(signUpHeader.isDisplayed(), "Sign-up page not displayed");
	}
}
