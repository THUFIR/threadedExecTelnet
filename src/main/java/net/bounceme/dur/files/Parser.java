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

    private Map<String, String> triggerMap = null;

    public Parser() {
        triggerMap = new HashMap();
        triggerMap.put(".*MAIN.*", "main menu found, press 1");
        triggerMap.put("Press Return to continue:", "press return");
    }

    private void pullTrigger(String line, Map.Entry<String, String> entry) {
        log.info(line);
        log.info(entry.toString());
    }

    private void triggers(String line) {
        boolean match = false;
        Pattern pattern = null;
        Matcher matcher = null;

        Iterator<Map.Entry<String, String>> entries = triggerMap.entrySet().iterator();

        while (!match) {
            while (entries.hasNext()) {
                Map.Entry<String, String> entry = entries.next();
                pattern = Pattern.compile(entry.getKey());
                matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    pullTrigger(line, entry);
                }
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
