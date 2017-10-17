package com.ciastek.shell;

import java.io.File;

public class ChangeDirectoryCommand extends Command {

    @Override
    public void executeCommand(ShellDirectory directory) {
        File currentDirectory = directory.getCurrentDirectory();
        if(commandParameters[1].equals("..")){
            directory.setCurrentDirectory(new File(currentDirectory.getParent()));
        } else {
            File newDirectory = new File(currentDirectory.getAbsolutePath() + "\\" + commandParameters[1]);
            if (newDirectory.isDirectory()){
                directory.setCurrentDirectory(newDirectory);
            }
        }
    }
}
