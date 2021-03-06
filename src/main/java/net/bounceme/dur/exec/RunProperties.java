package net.bounceme.dur.exec;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Queue;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import net.bounceme.dur.mud.PropertiesHandler;

public class RunProperties {

    private final static Logger log = Logger.getLogger(RunProperties.class.getName());
    private Properties properties = null;
    private final ExecList execList = null;

    private RunProperties() {
    }

    public RunProperties(Properties p) {
        this.properties = p;
    }

    public void handleProperties() throws IOException {
        log.fine(properties.toString());
        PropertiesHandler propertiesHandler = new PropertiesHandler(properties);
        Queue<String> queue = propertiesHandler.commandQueue();
        List<String> list = queue.stream().collect(Collectors.toCollection(ArrayList::new));

        log.fine(list.toString());
        ExecList listExec = new ExecList(list);
        listExec.execute();
    }
}
