package net.bounceme.dur.exec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.List;
import java.util.logging.Logger;

public class ExecList {

    private final static Logger log = Logger.getLogger(ExecList.class.getName());
    private List<String> listToExec = null;

    private ExecList() {
    }

    ExecList(List<String> list) {
        this.listToExec = list;
    }

    public void execute() throws IOException {
        log.info(listToExec.toString());

        String[] arrayToExec = listToExec.toArray(new String[0]);
        Process process = Runtime.getRuntime().exec(arrayToExec);

        InputStream inputStream = process.getInputStream();
        Reader inputStreamReader = new InputStreamReader(inputStream);
        try (BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                System.out.flush();
            }
        }
    }

}
