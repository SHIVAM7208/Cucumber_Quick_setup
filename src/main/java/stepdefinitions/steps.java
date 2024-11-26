package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import UIcode.Account;
import UIcode.SignUp;
import hooks.Hooks;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.WebDriverSingleton_factory;

public class steps {
	private static WebDriver driver;
	SignUp up;
	Account acc;
	
	
	@Given("Website URL Open")
	public void website_url_open() {
	    // Write code here that turns the phrase above into concrete actions
		 driver = WebDriverSingleton_factory.getDriver("chrome");
		    up = new SignUp(driver); // Ensure this instance is created correctly
		    up.URL(); // Navigate to the URL
		
		
	}
	@When("Userer input email and password")
	public void userer_input_email_and_password() {
		up.username_input();
		up.password_input();
		up.Login_B();
	}
	@Then("verify the title of page.")
	public void verify_the_title_of_page() {
		String expectedTitle = "Dashboard"; // Replace with actual title
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title verification failed!");
        return;
	  
	}
	  @Given("after sucessfully login")
	  public void after_sucessfully_login() {     up.verify_login_pg();    }
	  
	  @And("Click on the Account button")
	  public void click_on_the_account_button() {
		  acc = new Account(driver);
		  
		  acc.Acc_profile_Click();
		  
		  
	     
	  }
	  @Then("verify all links of Account are clickable")
	  public void verify_all_links_of_account_are_clickable() {
		  Scenario scenario = Hooks.getScenario();
		  acc.VerfiyAllURLs(scenario);;
	     
	  }
	
	
	
}
