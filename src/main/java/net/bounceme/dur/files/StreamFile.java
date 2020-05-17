package net.bounceme.dur.files;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFile {

    private final static Logger log = Logger.getLogger(StreamFile.class.getName());
    private Parser p = new Parser();

    public StreamFile() {
    }

    public void read(String filePath) throws IOException, URISyntaxException {
//        Stream<String> stream = Files.lines(Paths.get(new URI(filePath)));
        URI foo = new URI(filePath);
        Path bar = Paths.get(foo);
        Stream<String> stream = Files.lines(bar);
        List<String> list = stream.collect(Collectors.toList());
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            p.foo(listIterator.previous().toString());
        }
    }

}
