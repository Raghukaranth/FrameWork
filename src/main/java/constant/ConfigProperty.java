package constant;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static utils.file.FilePath.CONFIG_PROPS;

public class ConfigProperty {
    public static String URL;
    public static  String PLATFORM;
    public static String SUITE_NAME;
    public static String BROWSER;
    public static String PLATFORM_VERSION;
    public static String APP_PACKAGE;
    public static String APP_ACTIVITY;
    public static String NO_RESET;
    public static String UDID;
    private static Properties properties = new Properties();
    public static Map<String, String> configFileMap = new HashMap();
    Object obj;
    JSONObject json;

    private ConfigProperty(String configFile)  {
        try {
            FileInputStream inputStream = new FileInputStream(configFile);
            properties.load(inputStream);
        } catch(Exception e) { e.printStackTrace(); }
    }

    public ConfigProperty() { }
    public String getData(String value) {
        JSONParser parser = new JSONParser();
        try {
            obj = parser.parse(new FileReader(CONFIG_PROPS));
        } catch (ParseException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        json = (JSONObject) obj;
        return (String) json.get(value);
    }

    public void setData() {
        URL = new ConfigProperty().getData("url");
        PLATFORM = new ConfigProperty().getData("platform");
        BROWSER = new ConfigProperty().getData("genericLib");
        URL = new ConfigProperty().getData("url");

        PLATFORM_VERSION =  new ConfigProperty().getData("platform_version");
        APP_PACKAGE = new ConfigProperty().getData("app_package");
        APP_ACTIVITY = new ConfigProperty().getData("app_activity");
        NO_RESET = new ConfigProperty().getData("no_reset");
        UDID = new ConfigProperty().getData("udid");
    }

    public static ConfigProperty getInstance(String configFile)  {
        ConfigProperty instance = null;

        if (instance == null) {
            instance = new ConfigProperty(configFile);
            try {
                Enumeration keys = properties.propertyNames();
                while (keys.hasMoreElements()) {
                    String key = (String) keys.nextElement();
                    String value = (null == System.getenv(key)) ? properties.getProperty(key) : System.getenv(key);
                    configFileMap.put(key, value);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
}
