package com.ciastek.shell.commands;

import com.ciastek.shell.ShellParameters;

public class PromptCommand extends Command {
    @Override
    public void executeCommand(ShellParameters shellParameters) {
        if (commandParameters.length > 1){
            changePrompt(shellParameters);
        }
    }

    private void changePrompt(ShellParameters shellParameters){
        String commandParameter = commandParameters[1];
        if(commandParameter.equals("$cwd")){
            shellParameters.setPromptValue(shellParameters.getCurrentDirectory().getAbsolutePath() + ">");
            shellParameters.setPromptDirectory(true);
        } else if (commandParameter.equals("reset")){
            shellParameters.resetPrompt();
        } else {
            shellParameters.setPromptValue(commandParameter + ">");
        }
    }
}
