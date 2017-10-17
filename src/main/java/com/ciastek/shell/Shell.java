package com.ciastek.shell;

import com.ciastek.shell.commands.*;

import java.util.HashMap;

public class Shell {
    private final ShellParameters shellParameters;
    private boolean running = true;
    private HashMap<String, Command> possibleCommands;

    public Shell(){
        shellParameters = new ShellParameters();
        possibleCommands = new HashMap<>();
        possibleCommands.put("cd", new ChangeDirectoryCommand());
        possibleCommands.put("dir", new DirectoryContentCommand());
        possibleCommands.put("tree", new TreeCommand());
        possibleCommands.put("prompt", new PromptCommand());

        //TODO: add statistics command
    }

    public void receiveCommand(String receivedCommand){
        String[] commandParameters = receivedCommand.split(" ");
        String command = commandParameters[0];

        if(possibleCommands.containsKey(command)){
           Command currentCommand =  possibleCommands.get(command);
           currentCommand.setCommandParameters(commandParameters);
           currentCommand.executeCommand(shellParameters);
        } else if (command.equals("exit")){
            running = false;
        } else {
            System.out.println(receivedCommand + ": unknown command");
        }
    }

    public String getPrompt(){
        return shellParameters.getPrompt();
    }

    public boolean isRunning(){
        return running;
    }
}
