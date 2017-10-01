import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


/**
 * Created by eldadyaakobi on 9/28/17.
 */
public class LightLeds {

    private Socket socket = null;

    // make connection to ip and port
    private void socketConnect(String ip, int port) throws UnknownHostException, IOException {

        System.out.println("[connecting to socket...]");
        this.socket = new Socket(ip, port);
    }

    public String echo(int message) {
        try {

            PrintWriter out = new PrintWriter(getSocket().getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(getSocket().getInputStream()));

            out.println(message);
            String returnedString = in.readLine();

            in.close();
            out.close();
            getSocket().close();


            return returnedString;


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Socket getSocket() {
        return socket;
    }

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {

        LightLeds client = new LightLeds();

        // TCP connection
        String ip = "127.0.0.1";
        int port = 6969;


        client.socketConnect(ip, port);

        System.out.println("How many leds would you like to light ?\n");

        Scanner input = new Scanner(System.in);
//        String number = input.next();
//        String message = "I want to light " + number + " Leds";
        int number = input.nextInt();

        System.out.println("Sending: " + number);
        String returnedMessage = client.echo(number);
        System.out.println("receiving: " +  returnedMessage);

    }
}
