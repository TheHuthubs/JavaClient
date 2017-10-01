import java.io.IOException;
import java.net.UnknownHostException;

/**
 * Created by eldadyaakobi on 9/28/17.
 */
public class LedApp {

    IConnection connection = null;

    public LedApp() {
        connection = new Connection()

    }

    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {

        LedApp app = new LedApp();

    }
}
