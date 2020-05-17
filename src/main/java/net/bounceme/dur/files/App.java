package net.bounceme.dur.files;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Logger;

public class App {

    private final static Logger log = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws URISyntaxException {

        new FileWatcherThread().start();
    }
}
