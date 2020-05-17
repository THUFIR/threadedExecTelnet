package net.bounceme.dur.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StreamFile {

    private final static Logger log = Logger.getLogger(StreamFile.class.getName());

    public StreamFile() {
    }

    public void read(String fileName) throws IOException {
        BufferedReader br = Files.newBufferedReader(Paths.get(fileName));
        List<String> list = br.lines().collect(Collectors.toList());

        Triggers t = new Triggers(); //use records
        BotActions p = new BotActions(t.getTriggers());

        p.everyLine(list);

    }
}
