package com.ciastek.shell;

import java.util.Scanner;

public class ShellApplication {
    private static Shell shell;

    public static void main(String[] Args){
        Scanner input = new Scanner(System.in);
        shell = new Shell();


        while (shell.isRunning()){
            System.out.print("$>");
            String command = input.nextLine();
            System.out.println(shell.receiveCommand(command));
        }




    }
}
