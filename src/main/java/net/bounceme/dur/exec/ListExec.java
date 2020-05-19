package net.bounceme.dur.exec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ListExec {

    private final static Logger log = Logger.getLogger(ListExec.class.getName());
    private List<String> list = new ArrayList<>();

    private ListExec() {
    }

    ListExec(List<String> list) {
        this.list = list;
    }

    public void execute() throws IOException {
        log.info(list.toString());

        String[] commandsArray = list.toArray(new String[0]);
        Process process = Runtime.getRuntime().exec(commandsArray);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        for (String line; (line = bufferedReader.readLine()) != null;) {
            System.out.println(line);
        }
    }

}
