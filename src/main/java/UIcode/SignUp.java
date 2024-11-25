package UIcode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import page_object_factory.ObjectRepositoryLoader;

public class SignUp {
	private WebDriver driver;
    private ObjectRepositoryLoader objectRepository;

    public SignUp(WebDriver driver){
    								this.driver = driver;
    								objectRepository = new ObjectRepositoryLoader("C:\\Users\\ShivamDubey\\git\\Selenium_With_Shivam\\src\\main\\resources\\Config\\Signup.property");  }
    
    public void URL() 			 { driver.get(objectRepository.getLocator("signup.URL"));																								}
    
    public void username_input() { driver.findElement(By.id(objectRepository.getLocator("signup.email_id"))).sendKeys("sanket@jforcesolutions.com");        }
   
    public void password_input() { driver.findElement(By.id(objectRepository.getLocator("signup.password_id"))).sendKeys("sanket@123");  						}
 
    public void Login_B()        { driver.findElement(By.xpath(objectRepository.getLocator("signup.login_xpath"))).click(); 			   					}
 

}
