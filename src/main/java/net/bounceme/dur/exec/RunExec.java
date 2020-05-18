package net.bounceme.dur.exec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.logging.Logger;

public class RunExec {

    private final static Logger log = Logger.getLogger(RunExec.class.getName());

    public RunExec() {
    }

    public void start() throws IOException {
        String[] commandList = CommandList.baz();
        String commandString = Arrays.toString(commandList);
        Process process = Runtime.getRuntime().exec(commandList);
        OutputStream stdin = process.getOutputStream();
        InputStream stderr = process.getErrorStream();
        InputStream stdout = process.getInputStream();
        read();
        write(stdout);
        write(stderr);
    }

    private void write(InputStream stdin) throws UnsupportedEncodingException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stdin, "UTF-8"));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

    }

    private void read() {

        Thread read = new Thread() {

            String command = null;

            @Override
            public void run() {
                BufferedReader bufferedInput = new BufferedReader(new InputStreamReader(System.in));
                do {
                    try {
                        command = bufferedInput.readLine();
                    } catch (IOException ex) {
                        System.out.println(ex);
                    } finally {
                    }
                } while (true);
            }
        };
        read.start();
    }
}
