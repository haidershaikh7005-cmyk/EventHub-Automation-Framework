package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MyConfigReader {
    private Properties properties;

    // Load mylogin.properties
    public Properties initProp() {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("./src/test/resources/config/mylogin.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.out.println("Unable to read mylogin.properties file.");
        }
        return properties;
    }
}
