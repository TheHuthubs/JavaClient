package LedActions;

import infra.Connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class LightLeds implements ILightLeds {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 6969;
    private Connection connection = null;
    private int numberOfLedsToLight = 0;


    public void createClient() throws IOException, ClassNotFoundException {
        // creating TCP connection with the server
        this.connection = new Connection(HOST, PORT);
        this.connection.openSocket();

        System.out.println("[Client -> Server] Sending: You would like to light led number " + numberOfLedsToLight);
        String returnedMessageFromServer = this.sendMessageToServer();
        System.out.println("[Server -> Client] receiving: Led to turn on: " + returnedMessageFromServer);
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
