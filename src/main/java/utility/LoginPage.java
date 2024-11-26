package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor to initialize elements and set up WebDriver wait
    public LoginPage() {
        this.driver =WebDriverSingleton_factory.getDriver("Chrome") ;
       // this.wait = new WebDriverWait(driver, 10); // 10-second wait
        PageFactory.initElements(driver, this); // Initialize Page Factory elements
    }

    // Page Factory with @FindBy annotations for lazy loading of elements
    @FindBy(id = "username")
    private WebElement usernameField;
    
    
    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "loginButton")
    private WebElement loginButton;

    // Page Object Model methods for actions on the page

    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField)); // Wait until element is visible
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
    }

    // A high-level method that combines actions to perform the login
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        
        
    }
}