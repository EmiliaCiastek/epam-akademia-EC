package com.ciastek.shell;

import com.ciastek.shell.commands.ChangeDirectoryCommand;
import com.ciastek.shell.commands.Command;
import com.ciastek.shell.commands.DirectoryContentCommand;
import com.ciastek.shell.commands.TreeCommand;

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
        possibleCommands.put("tree", new TreeCommand());

        //TODO: add prompt and statistics commands
    }

    public void receiveCommand(String receivedCommand){
        String[] commandParameters = receivedCommand.split(" ");
        String command = commandParameters[0];

        if(possibleCommands.containsKey(command)){
           Command currentCommand =  possibleCommands.get(command);
           currentCommand.setCommandParameters(commandParameters);
           currentCommand.executeCommand(directory);
        } else if (command.equals("exit")){
            running = false;
        } else {
            System.out.println(receivedCommand + ": unknown command");
        }
    }

    public boolean isRunning(){
        return running;
    }
}
