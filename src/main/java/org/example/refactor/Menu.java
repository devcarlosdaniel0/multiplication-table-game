package org.example.refactor;

import org.example.refactor.enums.ChangeNumberOperation;
import org.example.refactor.enums.MathOperation;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Set;

public class Menu {
    private final Scanner scanner;
    private final GameState gameState;
    private final GameService gameService;
    private final ResourceBundle bundle = ResourceBundle.getBundle("text_content", Locale.getDefault());

    public Menu(Scanner scanner, GameState gameState, GameService gameService) {
        this.scanner = scanner;
        this.gameState = gameState;
        this.gameService = gameService;
    }

    public String showInitial() {
        System.out.print(bundle.getString("menu.initial"));

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
        System.out.printf(bundle.getString("menu.generalSettings"), gameState.isAnswerUntilCorrect());

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
        System.out.printf(bundle.getString("menu.generatedNumbers"), gameState.isRandomRange());

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
            case "6" -> gameService.checkActualNumbers();
        }
    }

    public String showGameOperation() {
        System.out.print(bundle.getString("menu.operations"));

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
        System.out.print(bundle.getString("menu.presets"));

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
