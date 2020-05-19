package net.bounceme.dur.mud;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;
import net.bounceme.dur.exec.RunProperties;

public class App {

    private final static Logger log = Logger.getLogger(App.class.getName());
    private static Properties properties = new Properties();

    public static void main(String[] args) throws IOException {
        properties.loadFromXML(App.class.getResourceAsStream("/bash_ls.xml"));
        new RunProperties(properties).handleProperties();
    }
}
