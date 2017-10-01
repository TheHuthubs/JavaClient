import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 * Created by eldadyaakobi on 9/28/17.
 */
public class LightLeds {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 6969;

    Connection connection = null;

    public LightLeds() {
        try {
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

        System.out.println("How many leds would you like to light ?\n");

        // receive the number of leds to light from the user
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        // Send message to the server and receive an ack
        System.out.println("Sending: You would like to light " + number + " Leds");
        String returnedMessage = this.sendMessageToServer(number);
        System.out.println("receiving: " +  returnedMessage);

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
}
