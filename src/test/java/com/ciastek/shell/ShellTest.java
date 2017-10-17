package com.ciastek.shell;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ShellTest {
    private Shell shell;

    @Before
    public void beforeTest(){
        shell = new Shell();
    }

    @Test
    public void should_Running_Be_False_When_Exit_Commans(){
        shell.receiveCommand("exit");
        assertEquals(false, shell.isRunning());
    }

}
