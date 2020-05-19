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
    private Properties p = null;
    private RunExec runExec = null;

    private Wrapperrr() {
    }

    public Wrapperrr(Properties p) {
        this.p = p;
    }

    public void runProperties() throws IOException {
        CommandMaker cm = new CommandMaker(p);
        Queue<String> queue = cm.commandQueue();
        List<String> list = queue.stream().collect(Collectors.toCollection(ArrayList::new));

        log.fine(list.toString());
        runExec = new RunExec(list);
    }
}
