package utility;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverHelper {
	
	// Get the WebDriver instance from Singleton class
    private static WebDriver driver = WebDriverSingleton_factory.getDriver("chrome"); // Pass desired browser


 
    // Wait Helpers
    public static WebElement waitForElementVisible(  By locator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(
            webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete")
        );
    }

    // Element Interaction
    public static void clickElement(  By locator) {
        driver.findElement(locator).click();
    }

    public static void enterText(  By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }

    public static boolean verifyElementExists(  By locator) {
        return !driver.findElements(locator).isEmpty();
    }

    // Drop-down Handling
    public static void selectByText(  By locator, String text) {
        Select dropdown = new Select(driver.findElement(locator));
        dropdown.selectByVisibleText(text);
    }

    // Alert Handling
    public static void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    // Screenshot Helper
    public static void takeScreenshot( String fileName) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File("target/screenshots/" + fileName + ".png");
            FileUtils.copyFile(screenshot, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Frame/Window Handling
    public static void switchToFrame(  String frameName) {
        driver.switchTo().frame(frameName);
    }

    public static void switchToWindow(  String windowHandle) {
        driver.switchTo().window(windowHandle);
    }

    // Cookie Management
    public static void addCookie(  String name, String value) {
        Cookie cookie = new Cookie(name, value);
        driver.manage().addCookie(cookie);
    }

    public static void deleteCookie(  String name) {
        driver.manage().deleteCookieNamed(name);
    }

    // Page Source Capture
    public static void capturePageSource(  String filePath) throws IOException {
        String pageSource = driver.getPageSource();
        FileWriter writer = new FileWriter(filePath);
        writer.write(pageSource);
        writer.close();
    }

    // Mouse Actions
    public static void hoverOverElement(  WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }


}
