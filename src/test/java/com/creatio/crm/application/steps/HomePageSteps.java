package com.creatio.crm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.creatio.crm.application.elements.HomePageElements;

public class HomePageSteps extends HomePageElements {
	
	public HomePageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Method to verify if the homepage is displayed successfully
	public void verifyHomePageIsDisplayed() {
//		if (appHubLink.isDisplayed()) {
//			System.out.println("Homepage is displayed successfully");
//		} else {
//			System.out.println("Homepage is not displayed");
//		}
		
		waitForElement(appHubLink);
		//log("info", "Homepage is displayed successfully");		
	}

	//Method to verify if the user profile icon is displayed successfully
	public void verifyUserProfileIconDisplayed() {
		waitForElement(userProfileIcon);
		//log("info", "User profile icon is displayed successfully");
	}
	
	//Method to click on the user profile icon
	public void clickOnUserProfileIcon() {
		waitForElement(userProfileIcon);
		click(userProfileIcon);
		//log("info", "Clicked on user profile icon");
	}
	
	//Method to click on the logout button
	public void clickOnLogoutButton() {
		waitForElement(logoutButton);
		click(logoutButton);
		//log("info", "Clicked on logout button");
	}
	
}
