package org.example;

import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    public static void menu() {
        System.out.println("Welcome to Command Line Interface game to memorize multiplication table");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("1. Play");
        System.out.println("2. Configure game");
        System.out.println("3. Leave");
        System.out.print("Type your option here: ");

        String option = scanner.nextLine();
        GameLogic.operateOption(option);
    }
}
