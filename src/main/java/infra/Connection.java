package infra;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by eldadyaakobi on 9/28/17.
 */
public class Connection implements IConnection {


    private String host;
    private int port;
    private Socket socket;

    public Connection(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void openSocket() {
        try {
            System.out.println("[connecting to socket...]");
            this.socket = new Socket(host, port);

        } catch (IOException e) {
            System.out.println("Unable to connect to socket, please verify that server is up...");
        }
    }

    public Socket getSocket() {
        return this.socket;
    }
}
