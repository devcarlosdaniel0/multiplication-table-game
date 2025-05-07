package org.example;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.getDefault());

    public static void menu() {
        System.out.print(bundle.getString("menu.text"));

        String option = scanner.nextLine();
        GameLogic.operateOption(option);
    }
}
