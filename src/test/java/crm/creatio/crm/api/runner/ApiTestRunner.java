package crm.creatio.crm.api.runner;


	import org.testng.annotations.Test;

	import io.cucumber.testng.AbstractTestNGCucumberTests;
	import io.cucumber.testng.CucumberOptions;


	@CucumberOptions(
			
			features = "APiFeatures",
			glue= {"com.creatio.crm.api.stepDefinitions"},
			plugin ={"pretty","html:Reports/AutomationReport.html"}
			)


	public class ApiTestRunner extends AbstractTestNGCucumberTests{
		
		//Add the below method  with @Test annotation to convert this to testng xml file
		@Test
		public void run() {
			System.out.println("Running Cucumber API Test Scripts...");
		}

	}


