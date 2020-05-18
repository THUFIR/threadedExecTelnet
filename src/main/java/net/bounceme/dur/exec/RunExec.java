package net.bounceme.dur.exec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Logger;

public class RunExec {

    private final static Logger log = Logger.getLogger(RunExec.class.getName());

    public RunExec() {
    }

    public void foo(CommandEnum commandEnum) {
        List<String> commandsList = new RunCommands(commandEnum).getCommands();

    }

    public void runProcessBuilder(CommandEnum commandEnum) throws IOException {
        List<String> commandsList = new RunCommands(commandEnum).getCommands();
        String[] commandsArray = commandsList.toArray(new String[0]);
        Process process = new ProcessBuilder(commandsList).start();
        InputStream inputStream = process.getInputStream();
        String newLine = System.getProperty("line.separator");
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder result = new StringBuilder();
        for (String line; (line = reader.readLine()) != null;) {
            System.out.println(line);
        }
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


/*


            Runtime rt = Runtime.getRuntime();
            System.out.println("Execing " + cmd[0] + " " + cmd[1] 
                               + " " + cmd[2]);
            Process proc = rt.exec(cmd);
            // any error message?
            StreamGobbler errorGobbler = new 
                StreamGobbler(proc.getErrorStream(), "ERROR");            
            
            // any output?
            StreamGobbler outputGobbler = new 
                StreamGobbler(proc.getInputStream(), "OUTPUT");
                
            // kick them off
            errorGobbler.start();
            outputGobbler.start();

 */
