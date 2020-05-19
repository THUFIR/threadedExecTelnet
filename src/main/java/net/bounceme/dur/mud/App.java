package net.bounceme.dur.mud;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class App {

    private final static Logger log = Logger.getLogger(App.class.getName());
    private static Properties properties = new Properties();

    public static void main(String[] args) throws IOException {
        properties.loadFromXML(App.class.getResourceAsStream("/foo.xml"));
        CommandMaker cm = new CommandMaker(properties);
        cm.objectToString();
//        new RunExec().exec(CommandEnum.LS);
    }
}

