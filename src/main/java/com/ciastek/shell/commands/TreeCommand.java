package com.ciastek.shell.commands;

import com.ciastek.shell.ShellParameters;

import java.io.File;

public class TreeCommand extends Command {
    @Override
    public void executeCommand(ShellParameters shellParameters) {
        System.out.print(getDirectorySubtree(shellParameters.getCurrentDirectory()));
    }

    private String getDirectorySubtree(File directory){
        StringBuilder builder = new StringBuilder();
        File[] files = directory.listFiles();

        builder.append(directory.getName())
                .append("\n")
                .append("-");

        for (File file:files) {
            builder.append("-");
            if (file.isDirectory()){
                builder.append(getDirectorySubtree(file));
            } else {
                builder.append("-")
                        .append(file.getName())
                        .append("\n");
            }
        }
        return builder.toString();
    }
}
