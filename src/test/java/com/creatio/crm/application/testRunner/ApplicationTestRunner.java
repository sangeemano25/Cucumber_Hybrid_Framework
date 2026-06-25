package com.creatio.crm.application.testRunner;

import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		
		features = "UIFeatures",
		glue= {"com.creatio.crm.application.stepDefinitions","com.creatio.crm.framework.base"},
		plugin ={"pretty","html:Reports/AutomationReport.html"}
		)


public class ApplicationTestRunner extends AbstractTestNGCucumberTests{
	
	//Add the below method  with @Test annotation to convert this to testng xml file
	@Test
	public void run() {
		System.out.println("Running Cucumber UI Test Scripts...");
	}

}
