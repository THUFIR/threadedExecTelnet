package net.bounceme.dur.mud;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;
import net.bounceme.dur.exec.Wrapperrr;

public class App {

    private final static Logger log = Logger.getLogger(App.class.getName());
    private static Properties properties = new Properties();

    public static void main(String[] args) throws IOException {
        properties.loadFromXML(App.class.getResourceAsStream("/ls.xml"));
        new Wrapperrr(properties).runProperties();

    }
}
