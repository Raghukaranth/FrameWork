package configuration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;

public class ConfigProperty {
    public static  String PLATFORM;
    public static String SUITE_NAME;
    Object obj;
    JSONObject json;
    public String getData(String value) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        obj = parser.parse(new FileReader("./src/test/resources/config.json"));
        json = (JSONObject) obj;
        return (String) json.get(value);
    }

    public void setData() throws IOException, ParseException {
        PLATFORM = new ConfigProperty().getData("platform");
    }


}
