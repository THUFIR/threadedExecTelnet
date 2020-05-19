package net.bounceme.dur.mud;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class App {

    private final static Logger log = Logger.getLogger(App.class.getName());
    private static Properties properties = new Properties();

    public static void main(String[] args) throws IOException {

        log.info("hi");

        log.info(properties.toString());

        properties.loadFromXML(App.class.getResourceAsStream("/ls.xml"));
        log.info(properties.toString());
        new net.bounceme.dur.exec.Wrapperrr(properties).runProperties();
        log.info("hi");

    }
}
