package com.ciastek.shell;

import java.util.HashMap;

public class Shell {
    private ShellDirectory directory;
    private boolean running = true;
    private HashMap<String, Command> possibleCommands;

    public Shell(){
        directory = new ShellDirectory();
        possibleCommands = new HashMap<>();
        possibleCommands.put("cd", new ChangeDirectoryCommand());
        possibleCommands.put("dir", new DirectoryContentCommand());
    }

    public void receiveCommand(String receivedCommand){
        System.out.println("directory: " + directory.getCurrentDirectory());

        String[] commandParameters = receivedCommand.split(" ");
        String command = commandParameters[0];

        if(possibleCommands.containsKey(command)){
           Command currentCommand =  possibleCommands.get(command);
           currentCommand.setCommandParameters(commandParameters);
           currentCommand.executeCommand(directory);
        } else if (command.equals("exit")){
            running = false;
        } else {
            System.out.println(command + ": unknown command");
        }

        System.out.println("directory: " + directory.getCurrentDirectory());
    }

    public boolean isRunning(){
        return running;
    }
}
