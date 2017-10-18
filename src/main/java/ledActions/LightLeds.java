package ledActions;

import configuration.ConfigurationUtility;
import infra.Connection;
import infra.MessageUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Properties;

public class LightLeds extends ConfigurationUtility implements ILightLeds {

    private final static String HOST = "server.connectHosts";
    private final static String PORT = "server.connectPort";
    private Connection connection = null;
    private int numberOfLedsToLight = 0;


    private String getClientProperties(String property)
    {
        return loadProperties(property);
    }

    public void createClient() throws IOException, ClassNotFoundException {
        // creating TCP connection with the server
        this.connection = new Connection(getClientProperties(HOST), Integer.parseInt(getClientProperties(PORT)));
        this.connection.openSocket();

        System.out.println(MessageUtil.CLIENT_TO_SERVER_NUMBER_LED_TO_LIGHT + numberOfLedsToLight);
        String returnedMessageFromServer = this.sendMessageToServer();
        System.out.println(MessageUtil.SERVER_TO_CLINET_LED_TO_LIGHT + returnedMessageFromServer);
    }

    public String sendMessageToServer() {
        try {

            PrintWriter out = new PrintWriter(this.connection.getSocket().getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(this.connection.getSocket().getInputStream()));

            // sending message to the server
            out.println(numberOfLedsToLight);
            String returnedString = in.readLine();

             // closing stream
            in.close();
            out.close();
            connection.getSocket().close();

            return returnedString;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void setNumberOfLedsToLight(int numberOfLedsToLight) {
        this.numberOfLedsToLight = numberOfLedsToLight;
    }
}
