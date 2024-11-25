package UIcode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import page_object_factory.ObjectRepositoryLoader;

public class Account {
	
	 private WebDriver driver;
	    private ObjectRepositoryLoader objectRepository;

	    public Account(WebDriver driver) {
	        this.driver = driver;
	        objectRepository = new ObjectRepositoryLoader("/Emertius_web/src/main/resources/Config/account.property");
	    }
	    
	    public void Acc_profile_Click() {
	    	driver.findElement(By.id(objectRepository.getLocator("acc.profile_link"))).click();
	    	
	    }

}
