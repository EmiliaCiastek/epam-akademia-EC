package com.ciastek.shell;

import java.io.File;
import java.util.Arrays;

public class Shell {
    private String commandResult = "";
    private File currentDirectory;
    private boolean running = true;

    public Shell(){
        currentDirectory = new File(System.getProperty("user.dir"));
    }

    public String receiveCommand(String command){

        switch (command){
            case "dir":
                commandResult += "Content of " + currentDirectory.getAbsolutePath();
                File files[] =  currentDirectory.listFiles();
                Arrays.sort(files);

                for (File file:files) {
                    if (file.isFile()){
                        commandResult += "\nFILE \t" + file.getName();
                    } else {
                        commandResult += "\nDIR \t" + file.getName();
                    }
                }
                break;
            case "exit":
                running = false;
                commandResult = "";
                break;
            default:
                commandResult = "";

        }

        return commandResult;
    }

    public boolean isRunning(){
        return running;
    }

}
