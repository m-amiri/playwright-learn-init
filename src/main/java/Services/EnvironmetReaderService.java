package Services;

import java.io.IOException;
import java.util.Properties;

public class EnvironmetReaderService {

    private static Properties props = new Properties();

    static {
        String envFile = System.getProperty("env");
        if (envFile == null) {
            envFile = "production";
        }
        String filePath = envFile.concat(".properties");
        try {
            props.load(EnvironmetReaderService.class.getClassLoader().getResourceAsStream(filePath));
        } catch (IOException e) {
            System.out.println("Could not load properties file");
        }
    }

    public static String getProperty(String key) {
        return props.getProperty(key);
    }

}
