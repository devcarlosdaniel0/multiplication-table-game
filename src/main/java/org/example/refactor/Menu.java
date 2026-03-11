package org.example.refactor;

import org.example.refactor.enums.ChangeNumberOperation;
import org.example.refactor.enums.MathOperation;

import java.util.Scanner;
import java.util.Set;

public class Menu {
    private final Scanner scanner;
    private final GameState gameState;
    private final GameService gameService;

    public Menu(Scanner scanner, GameState gameState, GameService gameService) {
        this.scanner = scanner;
        this.gameState = gameState;
        this.gameService = gameService;
    }

    public String showInitial() {
        System.out.println("1. Play");
        System.out.println("2. General settings");
        System.out.println("3. View score");
        System.out.print("> ");

        return scanner.nextLine();
    }

    public void initial() {
        String option = showInitial();

        switch (option) {
            case "1" -> gameService.play();
            case "2" -> generalSettings();
            case "3" -> gameService.viewScore();

            default -> gameState.stop();
        }
    }

    public String showGeneralSettings() {
        System.out.println("1. Generated numbers settings");
        System.out.printf("2. Toggle answer until correct (CURRENT: %s)%n", gameState.isAnswerUntilCorrect());
        System.out.println("3. Change math operations");
        System.out.print("> ");

        return scanner.nextLine();
    }

    public void generalSettings() {
        String option = showGeneralSettings();

        switch (option) {
            case "1" -> generatedNumberSettings();
            case "2" -> gameState.toggleAnswerUntilCorrect();
            case "3" -> changeGameOperation();
        }
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

    private void generatedNumberSettings() {
        String option = showGeneratedNumbersSettings();

        switch (option) {
            case "1" -> numberPresets();
            case "2" -> gameService.changeNumbers(ChangeNumberOperation.ADD);
            case "3" -> gameService.changeNumbers(ChangeNumberOperation.REMOVE);
            case "4" -> gameService.createCustomNumbers();
            case "5" -> gameService.randomRange();
            case "6" -> gameService.checkCurrentNumbers();
        }
    }

    public String showGameOperation() {
        System.out.println("1. Multiply");
        System.out.println("2. Add");
        System.out.println("3. Subtract");
        System.out.println("4. Random");
        System.out.print("> ");

        return scanner.nextLine();
    }

    private void changeGameOperation() {
        String option = showGameOperation();

        switch (option) {
            case "1" -> gameState.setMathOperation(MathOperation.MULTIPLY);
            case "2" -> gameState.setMathOperation(MathOperation.ADD);
            case "3" -> gameState.setMathOperation(MathOperation.SUBTRACT);
            case "4" -> gameState.setMathOperation(MathOperation.RANDOM);
        }
    }

    public String showNumberPresets() {
        System.out.println("1. Include only [6, 7, 8, 9]");
        System.out.println("2. Include only [3, 4, 6, 7, 8, 9]");
        System.out.println("3. Include only [2, 3, 4, 5, 6, 7, 8, 9]");
        System.out.println("4. Default [1 to 10]");
        System.out.print("> ");

        return scanner.nextLine();
    }

    private void numberPresets() {
        String option = showNumberPresets();

        Set<Integer> numbers = gameState.getNumbers();

        switch (option) {
            case "1" -> {
                numbers.clear();
                numbers.addAll(Set.of(6, 7, 8, 9));
            }
            case "2" -> {
                numbers.clear();
                numbers.addAll(Set.of(3, 4, 6, 7, 8, 9));
            }
            case "3" -> {
                numbers.clear();
                numbers.addAll(Set.of(2, 3, 4, 5, 6, 7, 8, 9));
            }
            case "4" -> {
                numbers.clear();
                numbers.addAll(Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
            }
        }
    }
}
