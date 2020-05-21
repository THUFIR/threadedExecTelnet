package net.bounceme.dur.mud;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;
import net.bounceme.dur.exec.RunProperties;

public class App {

    private final static Logger log = Logger.getLogger(App.class.getName());
    private static Properties properties = new Properties();
    private static final String filePrefix = "fail_raw_java_sequence";

    public static void main(String[] args) throws IOException {
        String propertiesFile = "/" + filePrefix + ".xml";
        log.info(propertiesFile);
        properties.loadFromXML(App.class.getResourceAsStream(propertiesFile));
        new RunProperties(properties).handleProperties();
    }
}
