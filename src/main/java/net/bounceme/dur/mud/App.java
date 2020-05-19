package net.bounceme.dur.mud;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class App {

    private final static Logger log = Logger.getLogger(App.class.getName());
    private static final Properties properties = null;

    public static void main(String[] args) throws IOException {
        properties.loadFromXML(App.class.getResourceAsStream("/java.xml"));
        new net.bounceme.dur.exec.Wrapperrr(properties).runProperties();
    }
}
