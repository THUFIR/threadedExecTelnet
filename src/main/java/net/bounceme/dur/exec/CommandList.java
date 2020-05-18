package net.bounceme.dur.exec;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Logger;

public class CommandList {

    private final static Logger log = Logger.getLogger(CommandList.class.getName());

    public CommandList() {
    }

    public static String[] telnetLocalHost() {
        Queue<String> q = new LinkedList<>();
        q.add("telnet");
        q.add("localhost");
        q.add("23");
        q.add("|");
        q.add("tee");
        q.add("out.log");
        List<String> list = new ArrayList<>(q);
        String[] baz = list.toArray(new String[0]);
        return baz;
    }

    public static String[] gedit() {
        Queue<String> q = new LinkedList<>();
        q.add("gedit");
        q.add("|");
        q.add("tee");
        q.add("out.log");
        List<String> list = new ArrayList<>(q);
        String[] baz = list.toArray(new String[0]);
        return baz;
    }

    public static String[] wunderground() {
        Queue<String> q = new LinkedList<>();
        q.add("telnet");
        q.add("rainmaker.wunderground.com");
        q.add("3000");
        q.add("|");
        q.add("tee");
        q.add("out.log");
        List<String> list = new ArrayList<>(q);
        String[] baz = list.toArray(new String[0]);
        return baz;
    }
}
