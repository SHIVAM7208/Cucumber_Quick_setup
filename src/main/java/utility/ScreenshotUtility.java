package utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {
	
	public static byte[] takeScreenshot(WebDriver driver, String scenarioName) {
        // Capture screenshot
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Define the screenshot folder path and filename
        String folderPath = "C:\\Users\\ShivamDubey\\git\\Selenium_With_Shivam\\target\\Screenshots";
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        // Clean the scenario name to make it valid for filenames
        String screenshotFileName = scenarioName.replaceAll("[^a-zA-Z0-9]", "_") + "_" + timestamp + ".png";

        // Create the destination file object
        File destinationFile = new File(folderPath + File.separator + screenshotFileName);

        try {
            // Copy the screenshot to the target location
            FileUtils.copyFile(screenshotFile, destinationFile);

            // Return the screenshot as byte array for Cucumber reporting
            return FileUtils.readFileToByteArray(destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
            return null; // Return null if there's an error
        }
	    }

}
