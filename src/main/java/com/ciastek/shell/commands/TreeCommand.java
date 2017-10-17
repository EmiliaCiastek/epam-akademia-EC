package com.ciastek.shell.commands;

import com.ciastek.shell.ShellDirectory;

import java.io.File;

public class TreeCommand extends Command {
    @Override
    public void executeCommand(ShellDirectory directory) {
        System.out.print(getDirectorySubtree(directory.getCurrentDirectory()));
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
