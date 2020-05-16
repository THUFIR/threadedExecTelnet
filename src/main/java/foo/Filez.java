package foo;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Filez {

    private final static Logger log = Logger.getLogger(Filez.class.getName());
    private Parser p = new Parser();

    public Filez() {
    }

    public void read(String s) throws IOException, URISyntaxException {
        URI fileURI = new URI(s);
        Stream<String> stream = Files.lines(Paths.get(fileURI.toString()));
        log.info("read file?");
        log.info(stream.toString());
       stream.forEach(log.info(stream.toString()));
    }
}
