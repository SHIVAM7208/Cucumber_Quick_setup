package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import UIcode.SignUp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_object_factory.WebDriverSingleton_factory;

public class steps {
	private static WebDriver driver;
	SignUp up;
	
	
	
	@Given("Website URL Open")
	public void website_url_open() {
	    // Write code here that turns the phrase above into concrete actions
		 driver = WebDriverSingleton_factory.getDriver("chrome");
		    up = new SignUp(driver); // Ensure this instance is created correctly
		    up.URL(); // Navigate to the URL
		
		
	}
	@When("Userer input email and password")
	public void userer_input_email_and_password() {
	    // Write code here that turns the phrase above into concrete actions
		up.username_input();
		up.password_input();
		up.Login_B();
	}
	@Then("verify the title of page.")
	public void verify_the_title_of_page() {
		String expectedTitle = "Dashboard "; // Replace with actual title
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title verification failed!");
        return;
	  
	}

	
	
	
}
