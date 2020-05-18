package net.bounceme.dur.exec;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class RunCommands {

    private final static Logger log = Logger.getLogger(RunCommands.class.getName());

    private RunCommands() {
    }

    public RunCommands(CommandEnum commandEnum) {
        Queue<String> queue = new Commands(commandEnum).getQueue();
        List<String> s = queue.stream().collect(Collectors.toCollection(ArrayList::new));
    }

}
