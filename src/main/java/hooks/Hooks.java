package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import page_object_factory.WebDriverSingleton_factory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {
	
	private static WebDriver driver;
    
    @Before
    public void setUp() {
    	 driver = WebDriverSingleton_factory.getDriver("chrome");
    	 System.out.println("Starting........");
    }

    @After
    public void tearDown(Scenario scenario) {
    	
        if (scenario.isFailed()) {
            try {
                // Capture the screenshot as a File
                File screenshotFile = ((TakesScreenshot) WebDriverSingleton_factory.getDriver("Chrome"))
                        .getScreenshotAs(OutputType.FILE);

                // Define the screenshot folder path and filename
                String folderPath = "C:\\Users\\ShivamDubey\\git\\Selenium_With_Shivam\\target\\Screenshort";
                String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
                String screenshotFileName = scenario.getName().replaceAll("[^a-zA-Z0-9]", "_") + "_" + timestamp + ".png";

             

                // Save the screenshot to the folder
                File destinationFile = new File(folderPath + File.separator + screenshotFileName);
                FileUtils.copyFile(screenshotFile, destinationFile);

                // Attach the screenshot to the Cucumber scenario for reporting
             scenario.attach(FileUtils.readFileToByteArray(destinationFile), "image/png", "Screenshot on Failure");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
 
        // Quit the WebDriver
        WebDriverSingleton_factory.quitDriver();
    }
    
   
}
