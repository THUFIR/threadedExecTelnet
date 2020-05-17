package net.bounceme.dur.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ListIterator;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StreamFile {

    private final static Logger log = Logger.getLogger(StreamFile.class.getName());
    private Parser p = new Parser();

    public StreamFile() {
    }

    public void read(String fileName) throws IOException {
        BufferedReader br = Files.newBufferedReader(Paths.get(fileName));
        List<String> list = br.lines().collect(Collectors.toList());

        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            p.foo(listIterator.previous().toString());
        }

    }

    /*
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
     */
}
