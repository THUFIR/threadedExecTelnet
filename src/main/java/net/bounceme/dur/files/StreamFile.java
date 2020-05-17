package net.bounceme.dur.files;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class StreamFile {

    private final static Logger log = Logger.getLogger(StreamFile.class.getName());
    private Parser p = new Parser();

    public StreamFile() {
    }

    public void read(String filePath) throws IOException, URISyntaxException {
        Stream<String> stream = Files.lines(Paths.get(filePath));
        stream.forEach(System.out::println);
    }

}
