package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utility.ScreenshotUtility;
import utility.WebDriverSingleton_factory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
	
	private static WebDriver driver;
	 private static Scenario scenario;
    
    @Before
    public void setUp(Scenario scenario) {
    	 driver = WebDriverSingleton_factory.getDriver("chrome");
    	 System.out.println("Starting........");
    	 Hooks.scenario = scenario;
    	 // Set the implicit wait (e.g., 10 seconds)
    	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    	    
    }
    public static Scenario getScenario() {
        return scenario;
    }

    @After
    public void tearDown(Scenario scenario) {
        // Take a screenshot based on the test result
        byte[] screenshot = ScreenshotUtility.takeScreenshot(driver, scenario.getName());

        if (scenario.isFailed()) {
            // If the test failed, attach the screenshot with "Screenshot on Failure"
            //System.out.println("Test failed: Attaching screenshot.");
            scenario.attach(screenshot, "image/png", "Screenshot on Failure");
        } else {
            // If the test passed, attach the screenshot with "Screenshot on Success"
          //  System.out.println("Test passed: Attaching screenshot.");
            scenario.attach(screenshot, "image/png", "Screenshot on Success");
        }

        // Quit the driver after each scenario
        WebDriverSingleton_factory.quitDriver();
    }
    
   
}
