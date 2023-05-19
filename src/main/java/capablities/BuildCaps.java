package capablities;

import configuration.ConfigProperty;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BuildCaps {
    DesiredCapabilities desiredCaps = new DesiredCapabilities();

    public void buildCaps() {
        if(ConfigProperty.PLATFORM.equalsIgnoreCase("Android")) {
            desiredCaps.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigProperty.PLATFORM);
            desiredCaps.setCapability(MobileCapabilityType.NO_RESET, "true");
        }
    }

    public void buildURL() throws MalformedURLException {
        URL url = new URL("http://localhost:4723/wd/hub");
    }
}
