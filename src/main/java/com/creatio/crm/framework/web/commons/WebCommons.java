package com.creatio.crm.framework.web.commons;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.creatio.crm.framework.base.BasePage;
import com.creatio.crm.framework.constants.Constants;
//import com.creatio.crm.framework.reports.Reports;
import com.creatio.crm.framework.utilities.PropUtil;

public class WebCommons {
	//This class contains common methods related to web application automation using selenium
	
	public WebDriver driver=BasePage.getDriver();
	Properties prop = PropUtil.readData("config.properties");

	//common method to launch application and verify page title 
	public void launchApplication() {
		driver.get(prop.getProperty("app.url"));
		wait(3);
		String expectedTitle=prop.getProperty("app.title");
		String actualTitle=driver.getTitle();
		Assert.assertTrue(actualTitle.contains(expectedTitle),"Title does not match");
		
	}
	
	//common method to scroll to the element
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		
	}
	
	//common method to click the element
	public void click(WebElement element) {
		scrollToElement(element);
		element.click();
	}
	
	//common method to click hidden element
	public void jsClick(WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	//common method to double-click element
	public void doubleClick(WebElement element) {
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();;
	}
	
	//common method to right-click element
	public void rightClick(WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	
	//common method to hover/mouse over/move to the element
	public void hoverOverElement(WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	//common method to enter text in textbox
	public void enterText(WebElement element, String text) {
		scrollToElement(element);
		element.clear();
		element.sendKeys(text);
		
	}
	
	//common methods to select dropdown value by visible text, value and index
	public void selectDropdownOption(WebElement dropdown, String option, String selectBy) {
		scrollToElement(dropdown);
		Select select=new Select(dropdown);
		switch(selectBy.toLowerCase()) {
		case "visibletext":
			select.selectByVisibleText(option);
			break;
		case "value":
			select.selectByValue(option);
			break;
		case "index":
			select.selectByIndex(Integer.parseInt(option));
			break;
		default:
			Assert.fail("Invalid selectBy value: "+selectBy);
		}
		
	}
	
	//common method to get text of element
	public String getElementText(WebElement element) {
		scrollToElement(element);
		return element.getText();
	}
	
	//common method to select checkbox or radio button
	public void selectCheckboxOrRadio(WebElement element) {
		scrollToElement(element);
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	//common method to get attribute value of element
	public String getElementAttribute(WebElement element, String attribute) {
		scrollToElement(element);
		return element.getDomAttribute(attribute);
	}
	
	//common method to get current URL
	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}	
	
	//common method to refresh page
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	//common method to display the status of element
	public boolean isElementDisplayed(WebElement element) {
		scrollToElement(element);
		return element.isDisplayed();
	}
	
	//common method to enable the status of element
	public boolean isElementEnabled(WebElement element) {
		scrollToElement(element);
		return element.isEnabled();
	}	
	
	//common method to implicit wait for page load
	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
	}
	
	//common method to wait for thread to sleep
	public void wait(int seconds) {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//common method to wait for element to be visible
	public void waitForElement(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//common method to wait until element disappear
	public void waitForElementToDisappear(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	//common method to switch to the frame from main page
	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	
	//common method to switch to frame from main page
		public void switchToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
	}
	
	//common method to switch to default content from frame
		public void switchToDefaultContent() {
			driver.switchTo().defaultContent();
		}
	//common method to switch to alert and accept or reject alert
		public void handleAlert(boolean accept) {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICIT_WAIT));
			wait.until(ExpectedConditions.alertIsPresent());
			if(accept) {
				driver.switchTo().alert().accept();
			}else {
				driver.switchTo().alert().dismiss();
			}
		}
		
		//common method to switch to alert and get alert text
		public String getAlertText() {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICIT_WAIT));
			wait.until(ExpectedConditions.alertIsPresent());
			return driver.switchTo().alert().getText();
		}
		
		//common method to switch to alert and enter text in alert textbox and accept alert
		public void enterTextInAlertAndAccept(String text) {
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(Constants.EXPLICIT_WAIT));
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().sendKeys(text);
		}	
		
		
		//common method to take screenshot for the entire browser window and save with test method name and timestamp
		public static String takeScreenshot(WebDriver driver, String screenshotName) throws IOException {
			String timestamp=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String filePath=System.getProperty("user.dir")+"\\creatioTestNGFramework26\\screenshots\\"+screenshotName+"_"+timestamp+".png";
			File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(filePath));
			return filePath;
		}
	
		//common method to take screenshot for specific web element and save with test method name and timestamp
		public static String takeScreenshot(WebElement element,String screenshotName) throws IOException {
			String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String filePath=System.getProperty("user.dir")+"\\creatioTestNGFramework26\\screenshots\\"+screenshotName+"_"+timeStamp+".png";
			File src= element.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(filePath));
			return filePath;
		}
		
//		//common method to print the message in extent report
//		public void log(String status, String message) {
//			if(status.equalsIgnoreCase("info")) {
//				Reports.Logger.info(message);
//			}else if(status.equalsIgnoreCase("pass")) {
//				Reports.Logger.pass(message);
//			}else if(status.equalsIgnoreCase("fail")) {
//				Reports.Logger.fail(message);
//			}else if(status.equalsIgnoreCase("warning")) {
//				Reports.Logger.warning(message);
//			}else if(status.equalsIgnoreCase("skip")) {
//				Reports.Logger.skip(message);
//			}else {
//				Reports.Logger.info(message);
//		}
				
			
	//}
}
