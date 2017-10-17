package com.ciastek.shell;

import java.io.File;

public class ShellDirectory {
    private File currentDirectory;

    public ShellDirectory(){
        currentDirectory = new File(System.getProperty("user.dir"));
    }

    public File getCurrentDirectory() {
        return currentDirectory;
    }

    public void setCurrentDirectory(File currentDirectory) {
        this.currentDirectory = currentDirectory;
    }
}
