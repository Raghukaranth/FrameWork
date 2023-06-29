package utils.file;

public interface FilePath {
    String SCREEN_SHOT_PATH = System.getProperty("user.dir") + "/screenshots/";
    String CONFIG_PROPS = System.getProperty("user.dir") + "/src/test/resources/config.json";
    String DATA_PROPS = System.getProperty("user.dir") + "/src/test/resources/apiExcel.xlsx";
    String TEST_DIR_PATH = System.getProperty("user.dir")+ "/src/test/java";
    String APPIUM_SERVER_IP="127.0.0.1";
    String APPIUM_JS_FILE=System.getProperty("user.home")+"\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
}
