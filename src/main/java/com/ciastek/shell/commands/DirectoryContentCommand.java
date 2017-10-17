package com.ciastek.shell.commands;

import com.ciastek.shell.ShellParameters;

import java.io.File;

public class DirectoryContentCommand extends Command {

    @Override
    public void executeCommand(ShellParameters parameters) {
        getContentOfCurrentDirectory(parameters.getCurrentDirectory());
    }

    private void getContentOfCurrentDirectory(File directory) {
        File files[] =  directory.listFiles();
        StringBuilder builder = new StringBuilder();
        builder.append("Content of ")
                .append(directory.getAbsolutePath());

        for (File file:files) {
            if (file.isFile()){
                builder.append("\nFILE \t")
                        .append(file.getName());
            } else {
                builder.append("\nDIR \t")
                        .append(file.getName());
            }
        }

        System.out.println(builder.toString());
    }
}
