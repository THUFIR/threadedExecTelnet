package net.bounceme.dur.mud;

import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Queue;
import java.util.logging.Logger;

public class PropertiesHandler {

    private final static Logger log = Logger.getLogger(PropertiesHandler.class.getName());
    private Properties properties = null;

    private PropertiesHandler() {
    }

    public PropertiesHandler(Properties properties) {
        this.properties = properties;
        log.fine(this.properties.toString());
    }

    public Queue<String> commandQueue() {
        log.fine(properties.toString());
        Enumeration enumeration = properties.propertyNames();
        Queue<String> queue = new LinkedList<>();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement().toString();
            queue.add(properties.getProperty(key));
        }

        Collections.reverse((List) queue);

        queue.forEach((s) -> {
            log.fine(s);
        });

        return queue;
    }
}
