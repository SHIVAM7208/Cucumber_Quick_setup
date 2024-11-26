package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( 
		
		features = "C:\\Users\\ShivamDubey\\git\\Selenium_With_Shivam\\src\\main\\resources\\feature\\signUp.feature"
		,glue ={"stepdefinitions","hooks"}
		,monochrome = true	  
		,dryRun = false
		//,plugin = {"pretty","html:target/cucumber.html"}
		,plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		,tags = "@FE_48"//"@tag1"//
				
		
			   ) 

public class RunnerTest extends AbstractTestNGCucumberTests {
	
	
	

		
	}
