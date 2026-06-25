package com.creatio.crm.application.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.creatio.crm.application.elements.CookiesPageElements;

public class CookiesPageSteps extends CookiesPageElements {
	//This class will contain methods related to the steps performed on the cookies page of the application
	
	public CookiesPageSteps(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Method to verify if cookies pop-up is displayed
	public void verifyCookiesPopupIsDisplayed() {
		waitForElement(cookiesHeader);
		//log("info","Cookies pop-up is displayed");
	}
	
	//Method to verify if cookies pop-up content is displayed
	public void verifyCookiesPopupContentMessage(String expectedMessage) {
		waitForElement(cookiesContent);
		String actualMessage=getElementText(cookiesContent);
		Assert.assertEquals(actualMessage, expectedMessage, "Cookies pop-up content message does not match");
		//log("info","Cookies pop-up content is displayed");
	}
	
	//Method to verify cookies pop-up logos
	public void verifyCookiesPopupLogos() {
		waitForElement(creatioLogo);
		waitForElement(cookieBotLogo);
		//log("info","Cookies pop-up logos are displayed");
	}
	
	//Method to verify cookies selection buttons
	public void verifyCookiesSelectionButtons() {
		waitForElement(allowAllButton);
		waitForElement(allowSelectionButton);
		waitForElement(denyButton);
		//log("info","Cookies selection buttons are displayed");
	}
	
	//Method to verify cookies selection switches
	public void verifyCookiesSelectionSwitches() {
		waitForElement(necessarySwitchButton);
		waitForElement(preferencesSwitchButton);
		waitForElement(statisticsSwitchButton);
		waitForElement(marketingSwitchButton);
		//log("info","Cookies selection switches are displayed");
	}
	
	//Method to verify show details link
	public void verifyShowDetailsLink() {
		waitForElement(showDetailsLink);
		//log("info","Show details link is displayed");
	}
	
	//Method to click show details link
	public void clickOnShowDetailsLink() {
		click(showDetailsLink);
		//log("info","Clicked on show details link");
	}
	
	//Method to verify cookies pop-up expanded view
	public void verifyCookiesPopupExpandedView() {
		waitForElement(cookiesPopupExpandedView);
		//log("info","Cookies pop-up expanded view is displayed");
	}
	
	//Method to click on select cookies button
	public void clickOnSelectionButton(String buttonName) {
		switch(buttonName.toLowerCase()) {
		case "allow all":
				click(allowAllButton);
				//log("info","Clicked on allow all button");
				break;
			case "allow selection":
				click(allowSelectionButton);
				//log("info","Clicked on allow selection button");
				break;
			case "deny":
				click(denyButton);
				//log("info","Clicked on deny button");
				break;
			default:
				//log("error","Invalid button name: "+buttonName);
				Assert.fail("Invalid button name: "+buttonName);
				
		}}
		
		//Method to verify if cookies pop-up is closed
		public void verifyCookiesPopupIsClosed() {
			try {
				waitForElementToDisappear(cookiesHeader);
				//log("info","Cookies pop-up is closed");
			}catch(Exception e) {
				//log("error","Cookies pop-up is not closed");
				Assert.fail("Cookies pop-up is not closed");
			}
		
	}

}
