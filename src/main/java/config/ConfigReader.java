package config;

import constants.ConstFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            properties = new Properties();
            FileInputStream inputStream = new FileInputStream(ConstFile.application_File_Path);
            properties.load(inputStream);
            inputStream.close();
        } catch (Exception e) {
            throw new RuntimeException("Could not load application.properties file!", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
