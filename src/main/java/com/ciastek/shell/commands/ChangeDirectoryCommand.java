package com.ciastek.shell.commands;

import com.ciastek.shell.ShellParameters;

import java.io.File;

public class ChangeDirectoryCommand extends Command {

    @Override
    public void executeCommand(ShellParameters parameters) {
        File currentDirectory = parameters.getCurrentDirectory();
        if(commandParameters.length > 1) {
            if (commandParameters[1].equals("..")) {
                parameters.setCurrentDirectory(new File(currentDirectory.getParent()));
            } else {
                File newDirectory = new File(currentDirectory.getAbsolutePath() + "\\" + commandParameters[1]);
                if (newDirectory.isDirectory()) {
                    parameters.setCurrentDirectory(newDirectory);
                }
            }
        }
    }
}
