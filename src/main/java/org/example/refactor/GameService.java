package org.example.refactor;

import org.example.refactor.enums.ChangeNumberOperation;
import org.example.refactor.enums.MathOperation;

import java.util.*;

public class GameService {
    private final Scanner scanner;
    private final Random random = new Random();
    private final GameState gameState;
    private final Menu menu;

    public GameService(Scanner scanner, GameState gameState, Menu menu) {
        this.scanner = scanner;
        this.gameState = gameState;
        this.menu = menu;
    }

    public void play() {
        if (gameState.getNumbers().isEmpty()) {
            System.out.println("Game numbers should not be empty");
            return;
        }

        while (gameState.isPlaying()) {
            int n1 = randomNumber();
            int n2 = randomNumber();

            int correctAnswer = gameState.getMathOperation().apply(n1,n2);

            boolean correct = false;

            while (!correct) {
                System.out.printf("%d %s %d? ", n1, gameState.getMathOperation().getSymbol(), n2);
                String input = scanner.nextLine().trim();

                if (!isInteger(input)) {
                    return;
                }

                int userAnswer = Integer.parseInt(input);

                if (userAnswer == correctAnswer) {
                    System.out.println("Correct!");
                    gameState.incrementScore();
                    correct = true;
                } else {
                    System.out.println("Wrong");
                    if (!gameState.isAnswerUntilCorrect()) {
                        break;
                    }
                }
            }
        }
    }

    public void viewScore() {
        System.out.printf("Your actual score is: %d%n", gameState.getScore());
    }

    public void generalSettings() {
        String option = menu.showGeneralSettings();

        switch (option) {
            case "1" -> generatedNumberSettings();
            case "2" -> gameState.toggleAnswerUntilCorrect();
            case "3" -> changeGameOperation();
        }
    }

    private void changeGameOperation() {
        String option = menu.showGameOperation();

        switch (option) {
            case "1" -> gameState.setMathOperation(MathOperation.MULTIPLY);
            case "2" -> gameState.setMathOperation(MathOperation.ADD);
            case "3" -> gameState.setMathOperation(MathOperation.SUBTRACT);
            case "4" -> gameState.setMathOperation(MathOperation.RANDOM);
        }
    }

    private void generatedNumberSettings() {
        String option = menu.showGeneratedNumbersSettings();

        switch (option) {
            case "1" -> numberPresets();
            case "2" -> changeNumbers(ChangeNumberOperation.ADD);
            case "3" -> changeNumbers(ChangeNumberOperation.REMOVE);
            case "4" -> createCustomNumbers();
            case "5" -> randomRange();
            case "6" -> checkCurrentNumbers();
        }
    }

    private void randomRange() {
        if (gameState.isRandomRange()) {
            gameState.toggleRandomRange();
            System.out.println("Random range is now set to: " + gameState.isRandomRange());
            return;
        }

        System.out.println("Type the interval of numbers to be random generated separated by spaces, ex: '1 30' (1 to 30)");
        System.out.print("> ");

        String input = scanner.nextLine().trim();
        String[] interval = input.split("\\s+");

        if (interval.length != 2) {
            System.out.println("Please insert 2 numbers, for the start and end of interval");
            return;
        }

        if (!isInteger(interval[0]) || !isInteger(interval[1])) {
            System.out.println("Must insert numbers!");
            return;
        }

        int start = Integer.parseInt(interval[0]);
        int end = Integer.parseInt(interval[1]);

        if (start <= 0 || end <= 0) {
            System.out.println("Must be greater than 0");
            return;
        }

        if (start >= end) {
            System.out.println("Should insert interval in ascending order");
            return;
        }

        Set<Integer> randomRangeInterval = gameState.getRandomRangeInterval();

        randomRangeInterval.clear();
        randomRangeInterval.add(start);
        randomRangeInterval.add(end);

        gameState.toggleRandomRange();
        System.out.println("Random range is now set to: " + gameState.isRandomRange());
    }

    private void createCustomNumbers() {
        System.out.println("""
                Type the numbers you want to include
                separated by spaces (ex: '2 6 10 15 30')
                Type 'done' when you finish.
                """);

        Set<Integer> customNumbers = new TreeSet<>();
        Set<Integer> actualNumbers = gameState.getNumbers();

        while (true) {
            System.out.print("Enter numbers or 'done' to finish: ");
            String userInput = scanner.nextLine().trim();

            if (userInput.equalsIgnoreCase("done")) {
                break;
            }

            String[] userNumbers = userInput.split("\\s+");

            for (String userNumber : userNumbers) {
                try {
                    int number = Integer.parseInt(userNumber.trim());
                    if (number <= 0) {
                        System.out.println("Number must greater than 0");
                        break;
                    }
                    customNumbers.add(number);
                } catch (NumberFormatException e) {
                    System.out.println("Should insert numbers, not Strings");
                    break;
                }
            }
        }

        if (customNumbers.isEmpty()) {
            System.out.println("Numbers cant be empty, previous was kept: " + actualNumbers);
            return;
        }

        actualNumbers.clear();
        actualNumbers.addAll(customNumbers);
    }

    private void numberPresets() {
        String option = menu.showNumberPresets();

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

    private void changeNumbers(ChangeNumberOperation changeNumberOperation) {
        Set<Integer> actualNumbers = gameState.getNumbers();

        while (true) {
            System.out.println("Actual numbers is: " + actualNumbers);
            System.out.printf("Type the number to be %s: ", changeNumberOperation);

            String input = scanner.nextLine().trim();

            if (!isInteger(input)) {
                System.out.println("Updated to: " + actualNumbers);
                return;
            }

            Integer number = Integer.parseInt(input);

            if (number <= 0) {
                System.out.println("Number should be greater than 0");
                break;
            }

            if (ChangeNumberOperation.ADD.equals(changeNumberOperation)) {
                actualNumbers.add(number);
            } else {
                actualNumbers.remove(number);
            }
        }

    }

    private Integer randomNumber() {
        if (!gameState.isRandomRange()) {
            List<Integer> numbersList = new ArrayList<>(gameState.getNumbers());
            return numbersList.get(random.nextInt(numbersList.size()));
        }

        List<Integer> randomRangeIntervalList = new ArrayList<>(gameState.getRandomRangeInterval());

        return random.nextInt(randomRangeIntervalList.get(0), randomRangeIntervalList.get(1));
    }

    private boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void checkCurrentNumbers() {
        Set<Integer> numbers = gameState.getNumbers();

        System.out.println("Current numbers is: " + numbers);
    }
}
