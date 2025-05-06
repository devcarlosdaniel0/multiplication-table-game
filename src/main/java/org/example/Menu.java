package org.example;

import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void menu() {
        System.out.println("""
        =======================================================================
        Welcome to Command Line Interface game to memorize multiplication table
        =======================================================================
        1. Play
        2. Configure game
        3. Check current score
        4. Reset score
        5. Leave (You can also type any letter)
        """);
        System.out.print("Type your option here: ");

        String option = scanner.nextLine();
        GameLogic.operateOption(option);
    }
}
