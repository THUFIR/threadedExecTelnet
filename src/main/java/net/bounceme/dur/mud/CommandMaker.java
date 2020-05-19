package net.bounceme.dur.mud;

import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;
import java.util.Stack;
import java.util.logging.Logger;

public class CommandMaker {

    private final static Logger log = Logger.getLogger(CommandMaker.class.getName());
    private Properties properties = new Properties();

    private CommandMaker() {
    }

    public CommandMaker(Properties p) {
        this.properties = p;
    }

    public void commandStackQueue() {
        Queue<String> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        Enumeration enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement().toString();
            queue.add(properties.getProperty(key));
            stack.add(properties.getProperty(key));
        }

        stack.forEach((s) -> {
            log.info(s);
        });
        
        queue.forEach((s) -> {
            log.info(s);
        });
    }
}
