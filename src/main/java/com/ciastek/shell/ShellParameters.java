package com.ciastek.shell;

import java.io.File;

public class ShellParameters {
    private File currentDirectory;
    private String promptValue = "$>";
    private boolean isPromptDirectory = false;

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

    public boolean isPromptDirectory() {
        return isPromptDirectory;
    }

    public void setPromptDirectory(boolean promptDirectory) {
        isPromptDirectory = promptDirectory;
    }

    public void updatePrompt(File newDirectory){
        promptValue = newDirectory.getAbsolutePath() + ">";
    }
}