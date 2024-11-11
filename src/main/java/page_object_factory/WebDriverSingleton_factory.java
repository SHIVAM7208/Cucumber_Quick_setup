package page_object_factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class WebDriverSingleton_factory {
	
	
		//Combined Singleton and Factory Design Pattern for WebDriver
		private static WebDriver driver;
		 private static Connection dbConnectionInstance;
		 private static Workbook excelWorkbookInstance;

	    // Private constructor to prevent instantiation
	    private WebDriverSingleton_factory() {}

	    // Public method to get the single WebDriver instance
	    public static WebDriver getDriver(String browserType) {
	        if (driver == null) {
	            driver = createDriver(browserType);
	        }
	        return driver;
	    }

	    // Method to get Database Connection instance
	    public static Connection getDBConnection() {
	        if (dbConnectionInstance == null) {
	            synchronized (WebDriverSingleton_factory.class) {
	                if (dbConnectionInstance == null) {
	                    try {
	                        dbConnectionInstance = DriverManager.getConnection(
	                            "jdbc:mysql://localhost:3306/yourdatabase",
	                            "username",
	                            "password"
	                        );
	                    } catch (SQLException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        }
	        return dbConnectionInstance;
	    }
	    
	    // Method to get Excel Workbook instance
	    public static Workbook getExcelWorkbook(String filePath) {
	        if (excelWorkbookInstance == null) {
	            synchronized (WebDriverSingleton_factory.class) {
	                if (excelWorkbookInstance == null) {
	                    try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
	                        excelWorkbookInstance = new XSSFWorkbook(fileInputStream);
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        }
	        return excelWorkbookInstance;
	    }
	    
	    
	    // Method to create a WebDriver instance based on the browser type
	    private static WebDriver createDriver(String browserType) {
	        switch (browserType.toLowerCase()) {
	            case "chrome":
	                  return new ChromeDriver();

	          //  case "firefox":
	              
	              //  return new FirefoxDriver();

	            case "edge":
	                 return new EdgeDriver();

	            default:
	                throw new IllegalArgumentException("Unknown browser type: " + browserType);
	        }
	    }

	    // Method to quit the driver and reset the instance to null
	    public static void quitDriver() {
	        if (driver != null) {
	            driver.quit();
	            driver = null;
	        }
	   	    
	    
	    // Method to close Database Connection
	    if (dbConnectionInstance != null) {
            try {
                dbConnectionInstance.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            dbConnectionInstance = null;
        }
	    
	    if (excelWorkbookInstance != null) {
            try {
                excelWorkbookInstance.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            excelWorkbookInstance = null;
        }
}
}
