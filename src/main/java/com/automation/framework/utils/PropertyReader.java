package com.automation.framework.utils;

import java.io.InputStream;
import java.util.Properties;

/**
 * Utility class for reading properties files
 */
public class PropertyReader {
    private static final Properties properties = new Properties();

    public static Properties loadProperties(String fileName) {
        try (InputStream input = PropertyReader.class.getClassLoader().getResourceAsStream(fileName)) {
            if (input == null) {
                throw new RuntimeException("Unable to find " + fileName);
            }
            properties.load(input);
            return properties;
        } catch (Exception e) {
            throw new RuntimeException("Error reading properties file", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
