package com.ciastek.shell;

import java.util.Scanner;

public class ShellApplication {
    private static Shell shell;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        shell = new Shell();

        while (shell.isRunning()){
            System.out.print("$>");
            String command = input.nextLine();
            shell.receiveCommand(command);
        }
    }
}
