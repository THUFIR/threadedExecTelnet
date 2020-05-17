package net.bounceme.dur.files;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Triggers {

    private final static Logger log = Logger.getLogger(Triggers.class.getName());

    private Map<String, String> triggers = null;

    public Triggers() {
        triggers = new HashMap();
        triggers.put("/^.*\\bMAIN MENU\\b.*$/m", "main menu found, press 1");
        triggers.put("Press Return to continue:", "press return");
    }

    public Map<String, String> getTriggers() {
        return triggers;
    }
}
