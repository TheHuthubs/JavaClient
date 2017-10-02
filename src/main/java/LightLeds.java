import graphicInterface.MainFrame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class LightLeds implements ILightLeds {


    private static final String HOST = "127.0.0.1";
    private static final int PORT = 6969;

    Connection connection = null;

    public LightLeds() {
        try {
            MainFrame mainFrame = new MainFrame();
            mainFrame.createMainFrame();

            createClient();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void createClient() throws IOException, ClassNotFoundException {
        // creating TCP connection with the server
        connection = new Connection(HOST, PORT);
        connection.openSocket();

        System.out.println("How many LEDs would you like to light ?\n");

        // receive the number of leds to light from the user
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        if (numOfLEDsValidator(number)) {
            // Send message to the server and receive an ack
            System.out.println("Sending: You would like to light " + number + " Leds");
            String returnedMessage = this.sendMessageToServer(number);
            System.out.println("receiving: " + returnedMessage);
        } else {
            System.out.println("This is a wrong input");
        }
    }

    public String sendMessageToServer(int message) {
        try {

            PrintWriter out = new PrintWriter(connection.getSocket().getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getSocket().getInputStream()));

            out.println(message);
            String returnedString = in.readLine();

            in.close();
            out.close();
            connection.getSocket().close();

            return returnedString;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private boolean numOfLEDsValidator(int num) { // Todo: fix this validator to alert if not number
        return num > 0;
    }

}
