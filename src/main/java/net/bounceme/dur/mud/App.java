package net.bounceme.dur.mud;

import java.io.IOException;
import java.util.logging.Logger;
import net.bounceme.dur.exec.RunExec;

public class App {

    private final static Logger log = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws IOException {
        RunExec re = new RunExec();
        re.start();
    }
}
