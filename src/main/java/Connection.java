import java.net.Socket;

/**
 * Created by eldadyaakobi on 9/28/17.
 */
public class Connection implements IConnection{

    private Socket socket = null;
    private String host;
    private int port;


    public Connection(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connectToServer() {

        try {
            socket = new Socket(host, port);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
