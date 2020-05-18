package net.bounceme.dur.files;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Triggers {

    private final static Logger log = Logger.getLogger(Triggers.class.getName());

    private Map<String, String> triggers = null;

    public Triggers() {
        triggers = new HashMap();
        //   triggers.put("Press Return to continue:", "press return");
        triggers.put("Press Return for menu:", "press return");
        //    triggers.put("or enter 3 letter forecast city code--", "press enter?");
        //   triggers.put("WEATHER UNDERGROUND MAIN MENU", "main menu found, press 1");
        //   triggers.put("Press Return to continue:", "press return");
    }

    public Map<String, String> getTriggers() {
        return triggers;
    }
}


//Press Return to continue:


//   Press Return to continue, M to return to menu, X to exit: x
