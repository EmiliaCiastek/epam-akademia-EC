package com.ciastek.shell;

public abstract class Command {
    public String[] commandParameters;
    public abstract void executeCommand(ShellDirectory directory);

    public void setCommandParameters(String[] parameters){
        commandParameters = parameters;
    }
}
