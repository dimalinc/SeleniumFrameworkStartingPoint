package utils;

import browser.Browser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfigManager {
    private static Properties propertyTestData = new Properties();
    private static Properties propertyConfig = new Properties();
    private static Logger log = Logger.getLogger(Browser.class.getName());


    private static void loadConfigManager() {
        if (propertyConfig.size()==0&&propertyTestData.size()==0) {
            try {
                log.log(Level.INFO, "Load Properties");
                File fileTestData = new File("src/main/resources/testData.properties");
                File fileConfig = new File("src/main/resources/config.properties");
                propertyConfig.load(new FileReader(fileTestData));
                propertyConfig.load(new FileReader(fileConfig));
            } catch (FileNotFoundException e) {
                log.log(Level.WARNING, e.getMessage());
            } catch (IOException e) {
                log.log(Level.WARNING, e.getMessage());
            }
        }
    }

    public static String getTestProperty(String property) {
        loadConfigManager();
        return propertyTestData.getProperty(property);
    }

    public static String getConfigProperty(String property) {
        loadConfigManager();
        return propertyConfig.getProperty(property);
    }

}
