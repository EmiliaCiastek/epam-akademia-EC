package com.ciastek.shell.commands;

import com.ciastek.shell.ShellParameters;

public abstract class Command {
    public String[] commandParameters;
    public abstract void executeCommand(ShellParameters parameters);

    public void setCommandParameters(String[] parameters){
        commandParameters = parameters;
    }
}
