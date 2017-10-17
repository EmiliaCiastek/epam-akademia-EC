package com.ciastek.shell;

import java.io.File;
import java.util.HashMap;

public class Shell {
    private String commandResult = "";
    private File currentDirectory;
    private boolean running = true;
    private HashMap<String, Command> possibleCommands;

    public Shell(){
        currentDirectory = new File(System.getProperty("user.dir"));
        possibleCommands = new HashMap<>();
    }

    public String receiveCommand(String receivedCommand){
        String[] commandParameters = receivedCommand.split(" ");
        String command = commandParameters[0];

        switch (command){
            case "dir":
                commandResult += "Content of " + currentDirectory.getAbsolutePath();
                getContentOfCurrentDirectory();
                break;
            case "exit":
                running = false;
                commandResult = "";
                break;
            case "cd ..":
                currentDirectory = new File(currentDirectory.getParent());
                break;
            default:
                commandResult = "";
        }

        return commandResult;
    }

    public boolean isRunning(){
        return running;
    }

    public File getCurrentDirectory(){
        return currentDirectory;
    }

    private void getContentOfCurrentDirectory() {
        File files[] =  currentDirectory.listFiles();

        for (File file:files) {
            if (file.isFile()){
                commandResult += "\nFILE \t" + file.getName();
            } else {
                commandResult += "\nDIR \t" + file.getName();
            }
        }
    }

}
