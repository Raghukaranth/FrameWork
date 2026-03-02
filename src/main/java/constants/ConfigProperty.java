package constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static utils.FilePath.CONFIG_PROPS;

public class ConfigProperty {
    public static String URL;
    public static String PLATFORM;
    public static String BROWSER;

    private static Properties properties = new Properties();
    public static Map<String, String> configFileMap = new HashMap<>();
    private static ConfigProperty instance;

    private ConfigProperty(String configFile) {
        try (FileInputStream inputStream = new FileInputStream(configFile)) {
            properties.load(inputStream);
            loadToMap();  // Copy to map
            populateStaticFields();  // Set static vars
        } catch (IOException e) {
            throw new RuntimeException("Failed to load " + configFile, e);
        }
    }

    private void loadToMap() {
        properties.forEach((key, value) ->
                configFileMap.put(key.toString(), value.toString()));
    }

    public void populateStaticFields() {
        URL = getData("url");
        PLATFORM = getData("platform");
        BROWSER = getData("browser");
    }

    public String getData(String key) {
        return configFileMap.get(key);  // ✅ From properties file
    }

    public static ConfigProperty getInstance() {
        if (instance == null) {
            instance = new ConfigProperty(CONFIG_PROPS);
        }
        return instance;
    }
}
