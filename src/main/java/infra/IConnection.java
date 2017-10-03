package infra;

import java.net.Socket;

public interface IConnection {

    void openSocket();

    Socket getSocket();
}
