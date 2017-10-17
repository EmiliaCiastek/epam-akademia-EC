package com.ciastek.shell.commands;

import com.ciastek.shell.ShellDirectory;
import com.ciastek.shell.commands.Command;

import java.io.File;

public class DirectoryContentCommand extends Command {

    @Override
    public void executeCommand(ShellDirectory directory) {
        getContentOfCurrentDirectory(directory.getCurrentDirectory());
    }

    private void getContentOfCurrentDirectory(File directory) {
        File files[] =  directory.listFiles();

        String commandResult = "Content of " + directory.getAbsolutePath();

        for (File file:files) {
            if (file.isFile()){
                commandResult += "\nFILE \t" + file.getName();
            } else {
                commandResult += "\nDIR \t" + file.getName();
            }
        }

        System.out.println(commandResult);
    }
}
