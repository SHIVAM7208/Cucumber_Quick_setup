package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( 
		
		features = "C:\\Users\\ShivamDubey\\git\\Selenium_With_Shivam\\src\\main\\resources\\feature\\signUp.feature"
		,glue ={"stepdefinitions","hooks"}
		,monochrome = true	  
		//,dryRun = true
		,plugin = {"pretty","html:target/cucumber.html"}
		//,tags = 
		
		)

public class RunnerTest extends AbstractTestNGCucumberTests {
	
	

		
	}
