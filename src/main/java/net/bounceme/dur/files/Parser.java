package net.bounceme.dur.files;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private final static Logger log = Logger.getLogger(Parser.class.getName());

    private Map<String, String> triggers = null;

    public Parser() {
        triggers = new HashMap();
        triggers.put(".*MAIN.*", "main menu found, press 1");
        triggers.put("Press Return to continue:", "press return");
    }

    private void pullTrigger(String line, Map.Entry<String, String> entry) {
        log.info(line);
        log.info(entry.toString());
    }

    private void triggers(String line) {
        Pattern pattern = null;
        Matcher matcher = null;

        Iterator<Map.Entry<String, String>> triggerEntries = triggers.entrySet().iterator();

        boolean triggered = false;
        while (triggerEntries.hasNext() && !triggered) {
            Map.Entry<String, String> entry = triggerEntries.next();
            pattern = Pattern.compile(entry.getKey());
            matcher = pattern.matcher(line);
            if (matcher.matches()) {
                pullTrigger(line, entry);
                triggered = true;
            }
        }
    }

    public void everyLine(List<String> list) {
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            triggers(listIterator.previous().toString());
        }
    }

}
