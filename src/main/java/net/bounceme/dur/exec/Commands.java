package net.bounceme.dur.exec;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Logger;

public class Commands {

    private final static Logger log = Logger.getLogger(Commands.class.getName());
    private Queue<String> q = new LinkedList<>();

    private Commands() {
    }

    public Commands(CommandEnum commandType) {
        switch (commandType) {
            case GNOME_TERMINAL:
                telnetLocalHost();
                break;
            case JAVA:
                java();
                break;
            case LS:
                ls();
                break;
            case LOCAL_TELNET:
                telnetLocalHost();
                break;
            case WUNDERGROUND:
                telnetLocalHost();
                break;
            case FOO:
                break;
        }
    }

    public Queue<String> getQueue() {
        return q;
    }

    private void java() {
        q.add("java");
        q.add("-version");
    }

    private void ls() {
        q.add("bash");
        q.add("-c");
        q.add("ls");
        q.add("/home/thufir");
    }

    private void telnetLocalHost() {
        q.add("bash");
        q.add("-c");
        q.add("telnet");
        q.add("localhost");
        //  q.add("23");
        //     q.add("|");
        //     q.add("tee");
        //    q.add("out.log");
    }

    private void gedit() {
        q.add("gedit");
        q.add("|");
        q.add("tee");
        q.add("out.log");
    }

    public void wunderground() {
        q.add("telnet");
        q.add("rainmaker.wunderground.com");
        q.add("3000");
        q.add("|");
        q.add("tee");
        q.add("out.log");
    }
}
