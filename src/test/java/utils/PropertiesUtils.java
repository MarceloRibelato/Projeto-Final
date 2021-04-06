package utils;

import java.io.IOException;
import java.util.Properties;

public class PropertiesUtils {

    Properties prop = new Properties();

    public String getProp(String valor) {
        try {
            if (System.getProperty("env") == null) {
                prop.load(getClass().getClassLoader().getResourceAsStream("dev.properties"));
            } else {
                prop.load(getClass().getClassLoader().getResourceAsStream(System.getProperty("env")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(valor);
    }


}
