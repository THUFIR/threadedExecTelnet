package net.bounceme.dur.exec;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Queue;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import net.bounceme.dur.mud.CommandMaker;

public class Wrapperrr {

    private final static Logger log = Logger.getLogger(Wrapperrr.class.getName());
    private Properties properties = new Properties();
    private RunExec runExec = null;

    private Wrapperrr() {
    }

    public Wrapperrr(Properties p) {
        this.properties = p;
    }

    public void runProperties() throws IOException {
        log.info(properties.toString());
        CommandMaker cm = new CommandMaker(properties);
        Queue<String> queue = cm.commandQueue();
        List<String> list = queue.stream().collect(Collectors.toCollection(ArrayList::new));

        log.fine(list.toString());
        runExec = new RunExec(list);
        runExec.execute();
    }
}
