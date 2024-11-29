package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

public class UtilityHelper {

    // Method to read a value from a properties file
    public static String readProperty(String filePath, String key) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            properties.load(fis);
            return properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to write a value to a properties file
    public static void writeProperty(String filePath, String key, String value) {
        Properties properties = new Properties();
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            properties.setProperty(key, value);
            properties.store(fos, "Updated properties file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get current timestamp as String
    public static String getCurrentTimestamp(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

  
    // Method to delete a file
    public static boolean deleteFile(String filePath) {
        File file = new File(filePath);
        return file.exists() && file.delete();
    }

    // Method to create a directory
    public static boolean createDirectory(String dirPath) {
        File directory = new File(dirPath);
        return !directory.exists() && directory.mkdirs();
    }

    // Method to check if a file exists
    public static boolean isFileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

 

    // Method to generate a random string of a given length
    public static String getRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(characters.charAt(random.nextInt(characters.length())));
        }
        return result.toString();
    }
    
    // Method to generate a random number within a range
    public static int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }


    // Method to generate a random email address
    public static String generateRandomEmail() {
        return "user" + getRandomNumber(1000, 9999) + "@example.com";
    }

  

    // Method to get the file extension
    public static String getFileExtension(String fileName) {
        if (fileName == null || !fileName.contains(".")) {
            return "";
        }
        return fileName.substring(fileName.lastIndexOf('.') + 1);
    }
}
