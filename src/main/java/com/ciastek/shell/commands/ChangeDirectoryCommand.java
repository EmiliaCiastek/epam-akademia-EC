package com.ciastek.shell.commands;

import com.ciastek.shell.ShellParameters;
import java.io.File;

public class ChangeDirectoryCommand extends Command {

    private File newDirectory;
    @Override
    public void executeCommand(ShellParameters parameters) {
        File currentDirectory = parameters.getCurrentDirectory();
        if(commandParameters.length > 1) {
            if (commandParameters[1].equals("..")) {
                newDirectory = new File(currentDirectory.getParent());
                parameters.setCurrentDirectory(newDirectory);
            } else {
                newDirectory = new File(currentDirectory.getAbsolutePath() + File.separator + commandParameters[1]);
                if (newDirectory.isDirectory()) {
                    parameters.setCurrentDirectory(newDirectory);
                }
            }

            updatePrompt(parameters);
        }
    }

    private void updatePrompt(ShellParameters parameters){
        if (parameters.isPromptDirectory())
            parameters.updatePrompt(parameters.getCurrentDirectory());
    }
}