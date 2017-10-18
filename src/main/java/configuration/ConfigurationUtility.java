package configuration;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// this class for loading any property from client property file which should be exist in classpath

public class ConfigurationUtility
{
    private final static String CLIENT_PROPERTIES_FILE = "src/main/config/client.properties";

    public InputStream propertiesFileStream;
    private Properties clientProperitesFile = new Properties();

    public String loadProperties(String property)
    {
        // getting file stream for client.properties file.
        propertiesFileStream = this.getClass().getClassLoader().getResourceAsStream(CLIENT_PROPERTIES_FILE);
        try {
            clientProperitesFile.load(propertiesFileStream);
            // returning requested property
            return clientProperitesFile.getProperty(property);
        } catch (IOException e) {
            System.out.println("[ERROR]: unable to load properties file or file does not exist!");
            e.printStackTrace();
        }
        return null;
    }
}
