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

    public List<String> foo() {
        Queue<String> q = new LinkedList<>();
        q.add("telnet localhost");
        List<String> list = new ArrayList<>(q);
        return list;
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
