package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions( 
		
		features = "C:\\Users\\Acer\\eclipse-workspace\\Emertius\\Emertius_web\\src\\main\\resources\\feature\\login.feature"
		,glue = {"stepDefinitions"}
		,monochrome = true	  
		,dryRun = true
		,plugin = {"pretty","html:target/cucumber.html"}
		//,tags = 
		
		)

public class RunnerTest extends AbstractTestNGCucumberTests {
	
	

		
	}
