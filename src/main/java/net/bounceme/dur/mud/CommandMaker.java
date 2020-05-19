package net.bounceme.dur.mud;

import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;
import java.util.logging.Logger;

public class CommandMaker {

    private final static Logger log = Logger.getLogger(CommandMaker.class.getName());
    private Properties properties = new Properties();

    private CommandMaker() {
    }

    public CommandMaker(Properties p) {
        this.properties = p;
    }

    public void objectToString() {

        Queue<String> q = new LinkedList<>();
        Enumeration enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement().toString();
            q.add(properties.getProperty(key));
        }
        log.info("queue\t\t\t" + q.toString());
    }

}
