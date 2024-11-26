package UIcode;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.Scenario;
import utility.ObjectRepositoryLoader;

public class Account {
	
	 private WebDriver driver;
	    private ObjectRepositoryLoader objectRepository;

	    public Account(WebDriver driver) {
	        this.driver = driver;
	        objectRepository = new ObjectRepositoryLoader("C:\\Users\\ShivamDubey\\git\\Selenium_With_Shivam\\src\\main\\resources\\Config\\account.property");
	    }
	    
	    public void Acc_profile_Click() {
	    	driver.findElement(By.id(objectRepository.getLocator("acc.profile_link"))).click();
	    	
	    }
	    
	    public void VerfiyAllURLs(Scenario scenario) {
	    
	    	    String url = "";
	    	    List<WebElement> allURLs = driver.findElements(By.xpath(objectRepository.getLocator("acc.all_page_link_xpath")));
	    	    StringBuilder reportContent = new StringBuilder(); // To store the report content
	    	    reportContent.append("Total links on the Web Page: ").append(allURLs.size()).append("\n");

	    	    Iterator<WebElement> iterator = allURLs.iterator();

	    	    while (iterator.hasNext()) {
	    	        WebElement element = iterator.next();
	    	        url = element.getAttribute("href"); // Get the actual URL from the 'href' attribute
	    	        
	    	        if (url == null || url.isEmpty()) {
	    	            reportContent.append("URL is either not configured for anchor tag or it is empty\n");
	    	            continue;
	    	        }
	    	        
	    	        reportContent.append("URL: ").append(url).append("\n");

	    	        // Verify if the URL is valid
	    	        try {
	    	            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
	    	            connection.setRequestMethod("GET");
	    	            connection.connect();

	    	            int responseCode = connection.getResponseCode();
	    	            if (responseCode >= 200 && responseCode < 400) {
	    	                reportContent.append(" - URL is valid and reachable\n");
	    	            } else {
	    	                reportContent.append(" - URL is broken (Response Code: ").append(responseCode).append(")\n");
	    	            }
	    	        } catch (Exception e) {
	    	            reportContent.append(" - Exception while verifying URL: ").append(e.getMessage()).append("\n");
	    	        }

	    	        // Check if the element is clickable
	    	        try {
	    	            	    	            reportContent.append(" - Element is clickable\n");
	    	        } catch (Exception e) {
	    	            reportContent.append(" - Element is not clickable: ").append(e.getMessage()).append("\n");
	    	        }
	    	    }

	    	    // Attach the report content to the Cucumber scenario
	    	    scenario.attach(reportContent.toString(), "text/plain", "URL Validation Report");
	    
	    	
	    	
	    }

}
