package net.bounceme.dur.exec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Queue;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import net.bounceme.dur.mud.CommandMaker;

public class RunExec {

    private final static Logger log = Logger.getLogger(RunExec.class.getName());
    private Properties p = null;

    private RunExec() {
    }

    public RunExec(Properties p) {
        this.p = p;
    }

    public void runP() throws IOException {
        CommandMaker cm = new CommandMaker(p);
        Queue<String> queue = cm.commandQueue();

        List<String> list = queue.stream().collect(Collectors.toCollection(ArrayList::new));

        log.info(list.toString());
        
        String[] commandsArray = list.toArray(new String[0]);
        Process process = Runtime.getRuntime().exec(commandsArray);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        for (String line; (line = bufferedReader.readLine()) != null;) {
            System.out.println(line);
        }
    }

    public void exec(CommandEnum commandEnum) throws IOException {
        List<String> commandsList = new RunCommands(commandEnum).getCommands();
        log.info(commandsList.toString());
        String[] commandsArray = commandsList.toArray(new String[0]);
        Process process = Runtime.getRuntime().exec(commandsArray);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        for (String line; (line = bufferedReader.readLine()) != null;) {
            System.out.println(line);
        }

    }

    private void bar(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder result = new StringBuilder();
        for (String line; (line = reader.readLine()) != null;) {
            System.out.println(line);
        }
    }

    public void runProcessBuilder(CommandEnum commandEnum) throws IOException {
        List<String> commandsList = new RunCommands(commandEnum).getCommands();
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
