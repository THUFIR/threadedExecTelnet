package net.bounceme.dur.exec;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class RunCommands {

    private final static Logger log = Logger.getLogger(RunCommands.class.getName());
    private List<String> commands = null;

    private RunCommands() {
    }

    public RunCommands(CommandEnum commandEnum) {
        Queue<String> queue = new Commands(commandEnum).getQueue();
        commands = queue.stream().collect(Collectors.toCollection(ArrayList::new));
    }

    public List<String> getCommands() {
        return commands;
    }

}
