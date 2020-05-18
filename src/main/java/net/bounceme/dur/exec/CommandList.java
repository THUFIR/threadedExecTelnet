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

    public static String[] baz() {
        Queue<String> q = new LinkedList<>();
        q.add("telnet localhost");
        q.add("localhost");
        q.add("23");
        q.add("|");
        q.add("tee");
        q.add("out.log");
        List<String> list = new ArrayList<>(q);
        String[] baz = list.toArray(new String[0]);
        return baz;
    }


    public static String[] foo() {
        Queue<String> q = new LinkedList<>();
        q.add("gedit");
        q.add("|");
        q.add("tee");
        q.add("out.log");
        List<String> list = new ArrayList<>(q);
        String[] baz = list.toArray(new String[0]);
        return baz;
    }

    private void bar() {
        String[] s = new String[6];
        s[0] = "telnet";
        s[1] = "rainmaker.wunderground.com";
        s[2] = "3000";
        s[3] = "|";
        s[4] = "tee";
        s[5] = "out.log";
        for (String item : s) {
            System.out.println(item);
        }
    }
}
