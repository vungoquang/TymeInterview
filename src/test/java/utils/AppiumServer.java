package utils;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.IOException;
import java.net.ServerSocket;

public class AppiumServer {

    private AppiumDriverLocalService service;
    private AppiumServiceBuilder builder;

    /**
     * This method use to start appium server
     *
     * @param
     * @return
     */
    public void startServer() {
    //Build the Appium service
        builder = new AppiumServiceBuilder();
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");

    //Start the server with the builder
        service = AppiumDriverLocalService.buildService(builder);
        checkIfServerIsRunning(4723);
        service.start();
    }

    /**
     * This method use to stop appium server
     *
     * @param
     * @return
     */
    public void stopServer() {
        service.stop();
    }

    /**
     * This method check server which specific port is running or not
     *
     * @param port
     * @return isServerRunning
     */
    public boolean checkIfServerIsRunning(int port) {

        boolean isServerRunning = false;
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            //If control comes here, then it means that the port is in use
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }
}
