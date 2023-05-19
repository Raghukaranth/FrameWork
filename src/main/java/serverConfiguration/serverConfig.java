package serverConfiguration;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class serverConfig {
    static AppiumDriverLocalService server;

    public static void startServer() {
        server = new AppiumServiceBuilder()
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        if(server.isRunning())
            System.out.println("server is running");
    }

    public static void stopServer() {
        server.stop();
    }


}
