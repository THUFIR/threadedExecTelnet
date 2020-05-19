package net.bounceme.dur.mud;

import java.io.IOException;
import java.util.logging.Logger;
import net.bounceme.dur.exec.CommandEnum;
import net.bounceme.dur.exec.RunExec;

public class App {

    private final static Logger log = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws IOException {
        Properties properties = null;
        properties.loadFromXML(App.class.getResourceAsStream("/readPeopleText.xml"));
        new RunExec().exec(CommandEnum.LS);
    }
}


/*
    13	    private void run() throws BaseXException, IOException, Exception {
    15	        Parser reader = new Parser(properties);
    16	        List<Person> people = reader.iterate();

 */
