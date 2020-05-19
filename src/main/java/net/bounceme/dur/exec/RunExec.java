package net.bounceme.dur.exec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Queue;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import net.bounceme.dur.mud.CommandMaker;

public class RunExec {

    private final static Logger log = Logger.getLogger(RunExec.class.getName());
    private Properties p = null;
    private List list = null;

    private RunExec() {
    }

    private RunExec(Properties p) {
        this.p = p;
    }

    RunExec(List<String> list) {
        this.list = list;
    }

    public void execute() throws IOException {
        CommandMaker cm = new CommandMaker(p);
        Queue<String> queue = cm.commandQueue();

        List<String> list = queue.stream().collect(Collectors.toCollection(ArrayList::new));

        log.info(list.toString());

        String[] commandsArray = list.toArray(new String[0]);
        Process process = Runtime.getRuntime().exec(commandsArray);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        for (String line; (line = bufferedReader.readLine()) != null;) {
            System.out.println(line);
        }
    }

}
