package com.ciastek.shell;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;


public class ShellTest {
    private Shell shell;

    @Before
    public void beforeTest(){
        shell = new Shell();
    }

    /*@Test
    public void should_Return_Current_Directory_Content_When_Command_DIR(){
        String content = "Content of C:\\Users\\emcia\\workspace\\Java\\epam-akademia \n" +
                "DIR \t .git \n" +
                "DIR \t .gradle \n" +
                "DIR \t .idea \n" +
                "DIR \t build \n" +
                "FILE \t build.gradle \n" +
                "DIR \t gradle \n" +
                "FILE \t gradlew \n" +
                "FILE \t gradlew \n" +
                "FILE \t readme.md \n" +
                "FILE \t settings.gradle \n" +
                "DIR \t src \n";

        assertEquals(content, shell.receiveCommand("dir"));
    }
    */

    @Test
    public void should_Running_Be_False_When_Exit_Commans(){
        shell.receiveCommand("exit");
        assertEquals(false, shell.isRunning());
    }

    @Test
    public void should_Change_Directory_To_Parent_With_cdCommand(){
       File directory = new File(System.getProperty("user.dir"));
       File parentDirectory = new File(directory.getParent());

        shell.receiveCommand("cd ..");
        assertEquals(parentDirectory, shell.getCurrentDirectory());
    }

}
