package net.bounceme.dur.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class StreamFile {

    private final static Logger log = Logger.getLogger(StreamFile.class.getName());
    private Parser p = new Parser();

    public StreamFile() {
    }

    public void read(String fileName) {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {
            //br returns as stream and convert it into a List
            list = br.lines().collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        list.forEach(System.out::println);
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
