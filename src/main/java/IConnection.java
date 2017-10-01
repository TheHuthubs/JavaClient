import java.net.Socket;

/**
 * Created by eldadyaakobi on 9/28/17.
 */
public interface IConnection {

    void openSocket();

    Socket getSocket();
}
