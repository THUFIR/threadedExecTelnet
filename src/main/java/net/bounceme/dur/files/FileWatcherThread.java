package net.bounceme.dur.files;

import java.util.logging.Logger;

public class FileWatcherThread extends Thread {

    private final static Logger log = Logger.getLogger(FileWatcherThread.class.getName());

    @Override
    public void run() {
        StreamFile f = new StreamFile();
        f.read("/home/thufir/telnet/wuther.log");
    }
}
