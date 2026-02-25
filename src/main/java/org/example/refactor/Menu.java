package org.example.refactor;

import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final GameState gameState;

    public Menu(GameState gameState) {
        this.gameState = gameState;
    }

    public String showInitial() {
        System.out.println("1. Play");
        System.out.println("2. General settings");
        System.out.println("3. View score");
        System.out.print("> ");

        return scanner.nextLine();
    }

    public String showGeneralSettings() {
        System.out.println("1. Generated numbers settings");
        System.out.printf("2. Toggle answer until correct (CURRENT: %s)%n", gameState.isAnswerUntilCorrect());
        System.out.println("3. Change math operations");
        System.out.print("> ");

        return scanner.nextLine();
    }

    public String showGameOperation() {
        System.out.println("1. Multiply");
        System.out.println("2. Add");
        System.out.println("3. Subtract");
        System.out.println("4. Random");
        System.out.print("> ");

        return scanner.nextLine();
    }

    public String showGeneratedNumbersSettings() {
        System.out.println("1. Presets");
        System.out.println("2. Add number (one at time)");
        System.out.println("3. Remove number (one at time)");
        System.out.println("4. Choose custom numbers");
        System.out.printf("5. Toggle random range (CURRENT: %s)%n", gameState.isRandomRange());
        System.out.println("6. Check current numbers");
        System.out.print("> ");

        return scanner.nextLine();
    }

    public String showNumberPresets() {
        System.out.println("1. Include only [6, 7, 8, 9]");
        System.out.println("2. Include only [3, 4, 6, 7, 8, 9]");
        System.out.println("3. Include only [2, 3, 4, 5, 6, 7, 8, 9]");
        System.out.println("4. Default [1 to 10]");
        System.out.print("> ");

        return scanner.nextLine();
    }
}
