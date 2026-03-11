package org.example.refactor;

import org.example.refactor.enums.ChangeNumberOperation;

import java.util.*;

public class GameService {
    private final Scanner scanner;
    private final GameState gameState;
    private final Random random = new Random();
    private final ResourceBundle bundle = ResourceBundle.getBundle("text_content", Locale.getDefault());

    public GameService(Scanner scanner, GameState gameState) {
        this.scanner = scanner;
        this.gameState = gameState;
    }

    public void play() {
        if (gameState.getNumbers().isEmpty()) {
            System.out.println(bundle.getString("game.numbers.empty"));
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
                    System.out.println(bundle.getString("game.correct"));
                    gameState.incrementScore();
                    correct = true;
                } else {
                    System.out.println(bundle.getString("game.wrong"));
                    if (!gameState.isAnswerUntilCorrect()) {
                        break;
                    }
                }
            }
        }
    }

    public void viewScore() {
        System.out.printf(bundle.getString("game.score"), gameState.getScore());
    }

    public void randomRange() {
        if (gameState.isRandomRange()) {
            gameState.toggleRandomRange();
            System.out.printf(bundle.getString("random.range.toggle"), gameState.isRandomRange());
            return;
        }

        System.out.print(bundle.getString("random.range.prompt"));

        String input = scanner.nextLine().trim();
        String[] interval = input.split("\\s+");

        if (interval.length != 2) {
            System.out.println(bundle.getString("random.range.invalid.length"));
            return;
        }

        if (!isInteger(interval[0]) || !isInteger(interval[1])) {
            System.out.println(bundle.getString("random.range.invalid.number"));
            return;
        }

        int start = Integer.parseInt(interval[0]);
        int end = Integer.parseInt(interval[1]);

        if (start <= 0 || end <= 0) {
            System.out.println(bundle.getString("random.range.invalid.positive"));
            return;
        }

        if (start >= end) {
            System.out.println(bundle.getString("random.range.invalid.order"));
            return;
        }

        Set<Integer> randomRangeInterval = gameState.getRandomRangeInterval();

        randomRangeInterval.clear();
        randomRangeInterval.add(start);
        randomRangeInterval.add(end);

        gameState.toggleRandomRange();
        System.out.printf(bundle.getString("random.range.toggle"), gameState.isRandomRange());
    }

    public void createCustomNumbers() {
        System.out.println(bundle.getString("custom.numbers.instructions"));

        Set<Integer> customNumbers = new TreeSet<>();
        Set<Integer> actualNumbers = gameState.getNumbers();

        while (true) {
            System.out.print(bundle.getString("custom.numbers.prompt"));
            String userInput = scanner.nextLine().trim();

            if (userInput.equalsIgnoreCase("done")) {
                break;
            }

            String[] userNumbers = userInput.split("\\s+");

            for (String userNumber : userNumbers) {
                try {
                    int number = Integer.parseInt(userNumber.trim());
                    if (number <= 0) {
                        System.out.println(bundle.getString("custom.numbers.positive"));
                        break;
                    }
                    customNumbers.add(number);
                } catch (NumberFormatException e) {
                    System.out.println(bundle.getString("custom.numbers.invalid"));
                    break;
                }
            }
        }

        if (customNumbers.isEmpty()) {
            System.out.println(bundle.getString("custom.numbers.empty") + actualNumbers);
            return;
        }

        actualNumbers.clear();
        actualNumbers.addAll(customNumbers);
    }

    public void changeNumbers(ChangeNumberOperation changeNumberOperation) {
        Set<Integer> actualNumbers = gameState.getNumbers();

        while (true) {
            System.out.println(bundle.getString("numbers.actual") + actualNumbers);
            System.out.printf(bundle.getString("numbers.prompt"), changeNumberOperation);

            String input = scanner.nextLine().trim();

            if (!isInteger(input)) {
                System.out.println(bundle.getString("numbers.updated") + actualNumbers);
                return;
            }

            Integer number = Integer.parseInt(input);

            if (number <= 0) {
                System.out.println(bundle.getString("numbers.invalid.positive"));
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

    public void checkActualNumbers() {
        Set<Integer> numbers = gameState.getNumbers();

        System.out.println(bundle.getString("numbers.actual") + numbers);
    }
}
