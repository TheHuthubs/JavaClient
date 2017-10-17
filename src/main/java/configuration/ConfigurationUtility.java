//package configuration;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//
//@Configuration
//@PropertySource("classpath:client.properties")
//public class ConfigurationUtility
//{
//
//    @Autowired
//    public Environment env;
//
//
//    public void bla()
//
//    {
//        String connectHost = env.getProperty("server");
//        System.out.println(connectHost);
//        //return connectHost;
//    }
//
//    public static void main(String[] args) {
//        ConfigurationUtility configurationUtility = new ConfigurationUtility();
//        configurationUtility.bla();
//    }
//}
