package foo;

import java.util.function.Consumer;
import java.util.logging.Logger;

public class Parser {

    private final static Logger log = Logger.getLogger(Parser.class.getName());

    public Parser() {
    }

    public void foo(String s) {
        log.info(s);
    }

}
