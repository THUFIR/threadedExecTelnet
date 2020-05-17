package net.bounceme.dur.files;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileWatcherThread extends Thread {

    private final static Logger log = Logger.getLogger(FileWatcherThread.class.getName());

    @Override
    public void run() {
        StreamFile f = new StreamFile();
        try {
            f.read("/home/thufir/telnet/wuther.log");
        } catch (IOException ex) {
            Logger.getLogger(FileWatcherThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
