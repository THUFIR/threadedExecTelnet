package net.bounceme.dur.mud;

import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
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

    public Queue<String> commandQueue() {
        Queue<String> queue = new LinkedList<>();
        Enumeration enumeration = properties.propertyNames();
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
