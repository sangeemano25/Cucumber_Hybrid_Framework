package com.creatio.crm.framework.base;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//import com.creatio.crm.framework.reports.Reports;
import com.creatio.crm.framework.utilities.PropUtil;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;



public class BasePage {

	//This class contains all common methods related to browser configurations and web-driver
	private static WebDriver driver;
	Properties prop = PropUtil.readData("Config.properties");
	
	//common method to launch browser window
	@Before
	public void setUpBrowser() {
		String browserName= prop.getProperty("browser.name");
		if(browserName.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")){
			driver = new EdgeDriver();
		}else {
			Assert.fail("Browser not supported");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	//Common method to verify scenario status and capture screenshots
	//capture screenshot and covert to byte array to incorporate in html file
	@After(order=1)
	public void reportFailure(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName()+"_Screenshot");
		}
	}
	
	//common method to close browser window
	@After(order=0)
	public void tearDownBrowser() {
		if(driver!=null) {
			driver.quit();
		}
	}
	
	//GETdriver()Method -to get WebDriver Instance(encapsulation-its done bcoz initially no driver within driver variable then later after setting up browser, we need browser details to store and share across all classes
	
	//setdriver()-Also,If browser window is suddenly changed and new tabs are opened,then we need to store those updated browser details to update webdriver instance
	 
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static void setDriver(WebDriver driverInstance) {
		driver = driverInstance;
	}
}
