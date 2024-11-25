package Runner;

import org.openqa.selenium.WebDriver;

import UIcode.SignUp;
import page_object_factory.WebDriverSingleton_factory;

public class Generaltest {
	private static WebDriver driver;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = WebDriverSingleton_factory.getDriver("chrome");
		
		SignUp up = new SignUp(driver);
		
		up.URL();
		up.username_input();
		up.password_input();
		up.Login_B();
		

	}

}
