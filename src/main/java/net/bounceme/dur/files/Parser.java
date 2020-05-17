package net.bounceme.dur.files;

import java.util.List;
import java.util.ListIterator;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private final static Logger log = Logger.getLogger(Parser.class.getName());

    public Parser() {
    }

    private void mainMenu(String line) {
        log.fine(line);
        Pattern pattern = Pattern.compile(".*MAIN.*");
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
            log.info(line);
            log.info("main menu found");
        }
    }

    private void pressReturn(String line) {
        log.fine(line);
        Pattern pattern = Pattern.compile("Press Return to continue:");
        Matcher matcher = pattern.matcher(line);
        if (matcher.matches()) {
            log.info(line);
            log.info("press return");
        }
    }

    private void singleLine(String line) {
        log.fine(line);
        pressReturn(line);
        mainMenu(line);
    }

    public void everyLine(List<String> list) {
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            singleLine(listIterator.previous().toString());
        }
    }

}
