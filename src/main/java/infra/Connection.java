package infra;

import java.io.IOException;
import java.net.Socket;

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
            System.out.println(MessageUtil.CONNECTING_TO_SOCKET);
            this.socket = new Socket(host, port);

        } catch (IOException e) {
            System.out.println(MessageUtil.UNABLE_TO_CONNET_TO_SOCKET);
        }
    }

    public Socket getSocket() {
        return this.socket;
    }
}
