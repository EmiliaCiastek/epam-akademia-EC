package com.ciastek.shell;

import java.io.File;

public class ShellParameters {
    private File currentDirectory;
    private String promptValue = "$>";

    public ShellParameters(){
        currentDirectory = new File(System.getProperty("user.dir"));
    }

    public File getCurrentDirectory() {
        return currentDirectory;
    }

    public void setCurrentDirectory(File currentDirectory) {
        this.currentDirectory = currentDirectory;
    }


    public void setPromptValue(String newPrompt){
        promptValue = newPrompt;
    }

    public void resetPrompt(){
        promptValue = "$>";
    }

    public String getPrompt() {
        return promptValue;
    }
}
