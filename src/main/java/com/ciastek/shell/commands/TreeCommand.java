package com.ciastek.shell.commands;

import com.ciastek.shell.ShellParameters;

import java.io.File;

public class TreeCommand extends Command {
    @Override
    public void executeCommand(ShellParameters shellParameters) {
        System.out.print(getDirectorySubtree(shellParameters.getCurrentDirectory()));
    }

    private String getDirectorySubtree(File directory){
        String result = directory.getName() + "\n";
        File[] files = directory.listFiles();

        for (File file:files) {
            result += "-";
            if (file.isDirectory()){
                result += getDirectorySubtree(file);
            } else {
                result += "-" + file.getName() + "\n";
            }
        }
        return result;
    }
}
