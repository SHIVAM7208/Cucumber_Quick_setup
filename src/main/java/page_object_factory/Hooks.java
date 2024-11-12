package page_object_factory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    
    @Before
    public void setUp() {
        WebDriverSingleton_factory.getDriver("Chrome");
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            // Capture screenshot on failure
            final byte[] screenshot = ((TakesScreenshot)  WebDriverSingleton_factory.getDriver("Chrome"))
                .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, scenario.getName() +"image/png", "Screenshot on Failure");
        }
        
        // Quit driver
        WebDriverSingleton_factory.quitDriver();
    }
}
