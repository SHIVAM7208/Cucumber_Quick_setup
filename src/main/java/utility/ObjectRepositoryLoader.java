package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ObjectRepositoryLoader{
	
	private Properties properties;

    public ObjectRepositoryLoader(String filePath) {
        properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file: " + filePath, e);
        }
    }

    public String getLocator(String key) {
        return properties.getProperty(key);
    }


}
