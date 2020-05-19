package net.bounceme.dur.mud;

import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class CommandMaker {

    private final static Logger log = Logger.getLogger(CommandMaker.class.getName());
    private Properties properties = new Properties();

    private CommandMaker() {
    }

    public CommandMaker(Properties p) {
        this.properties = p;
    }

    private void objectToString() {
        Set<Object> objectSet = properties.keySet();
        Set<String> stringSet = objectSet.stream().map(o -> convertToString(o)).collect(Collectors.toSet());
        log.info(stringSet.toString());
    }

}
