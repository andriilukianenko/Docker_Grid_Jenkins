package utils;


import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    private static Properties variableProperties;

    static {
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/conf.properties")) {
            variableProperties = new Properties();
            variableProperties.load(fileInputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key) {
        return variableProperties.getProperty(key);
    }


}