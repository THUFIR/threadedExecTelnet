package net.bounceme.dur.exec;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Logger;

public class Commands {

    private final static Logger log = Logger.getLogger(Commands.class.getName());
    private Queue<String> q = new LinkedList<>();

    public Commands() {
    }

    public Queue<String> telnetLocalHost() {
        q.add("telnet");
        q.add("localhost");
        q.add("23");
        q.add("|");
        q.add("tee");
        q.add("out.log");
        return q;
    }

    public Queue<String> gedit() {
        q.add("gedit");
        q.add("|");
        q.add("tee");
        q.add("out.log");
        return q;
    }

    public Queue<String> wunderground() {
        q.add("telnet");
        q.add("rainmaker.wunderground.com");
        q.add("3000");
        q.add("|");
        q.add("tee");
        q.add("out.log");
        return q;
    }
}
