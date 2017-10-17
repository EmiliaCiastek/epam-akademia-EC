package com.ciastek.shell.commands;

import com.ciastek.shell.ShellDirectory;
import com.ciastek.shell.commands.Command;

import java.io.File;

public class ChangeDirectoryCommand extends Command {

    @Override
    public void executeCommand(ShellDirectory directory) {
        File currentDirectory = directory.getCurrentDirectory();
        if(commandParameters.length > 1) {
            if (commandParameters[1].equals("..")) {
                directory.setCurrentDirectory(new File(currentDirectory.getParent()));
            } else {
                File newDirectory = new File(currentDirectory.getAbsolutePath() + "\\" + commandParameters[1]);
                if (newDirectory.isDirectory()) {
                    directory.setCurrentDirectory(newDirectory);
                }
            }
        }
    }
}
