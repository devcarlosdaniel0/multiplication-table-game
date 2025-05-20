package org.example;

import java.util.*;

public class GameLogic {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static final Set<Integer> table = new HashSet<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    private static boolean isPlaying = true;
    private static boolean isForceUntilCorrect = false;
    private static int score;
    private static final ResourceBundle bundle = ResourceBundle.getBundle("messages", Locale.getDefault());
    private static String gameMode = "*";

    public static void operateOption(String option) {
        while (isPlaying) {
            switch (option) {
                case "1" -> play(gameMode);
                case "2" -> generalSettings();
                case "3" -> checkScore();
                case "4" -> resetScore();
                default -> {
                    leave();
                }
            }
        }
    }

    private static void play(String gameMode) {
        if (table.isEmpty()) {
            System.out.println(bundle.getString("empty.warning"));
            presets();
            return;
        }


        List<Integer> numbers = new ArrayList<>(List.of(num1, num2));
        Collections.sort(numbers, Comparator.reverseOrder());

        String operation = gameMode;

        if (gameMode.equals("random")) {
            List<String> operations = List.of("*", "+", "-");
            operation = operations.get(random.nextInt(operations.size()));
        }

        String correctAnswer = switch (operation) {
            case "*" -> String.valueOf(num1 * num2);
            case "+" -> String.valueOf(num1 + num2);
            case "-" -> String.valueOf(numbers.get(0) - numbers.get(1));
            default -> "0";
        };

        while (true) {
            System.out.printf("%d %s %d ? ",
                    operation.equals("-") ? numbers.get(0) : num1,
                    operation,
                    operation.equals("-") ? numbers.get(1) : num2
            );

            String userAnswer = scanner.nextLine();

            if (!isValidNumber(userAnswer)) {
                System.out.println(bundle.getString("final.score") + score);
                Menu.menu();
                return;
            }

            if (userAnswer.equals(correctAnswer)) {
                score++;
                System.out.println(bundle.getString("correct"));
                break;
            } else {
                System.out.println(bundle.getString("wrong"));
                if (!isForceUntilCorrect) {
                    break;
                }
            }
        }
    }

    private static void generalSettings() {
        System.out.print(bundle.getString("general.settings.text").formatted(isForceUntilCorrect
                ? bundle.getString("forceUntilCorrect.mode.on")
                : bundle.getString("forceUntilCorrect.mode.off")));

        String option = scanner.nextLine();

        switch (option) {
            case "1" -> multiplicationTableSettings();
            case "2" -> toggleAnswerUntilCorrect();
            case "3" -> changeGameMode();
            default -> Menu.menu();
        }
    }

    private static void multiplicationTableSettings() {
        System.out.println(bundle.getString("multiplication.table.settings.text"));
        System.out.print(bundle.getString("configure.prompt"));

        String option = scanner.nextLine();

        switch (option) {
            case "1" -> presets();
            case "2" -> changeTable(Operation.ADD);
            case "3" -> changeTable(Operation.REMOVE);
            default -> Menu.menu();
        }
    }

    private static void changeGameMode() {
        System.out.print(bundle.getString("change.game.mode.text"));

        String option = scanner.nextLine();

        switch (option) {
            case "1" -> gameMode = "*";
            case "2" -> gameMode = "+";
            case "3" -> gameMode = "-";
            case "4" -> gameMode = "random";
            default -> Menu.menu();
        }
    }

    private static void toggleAnswerUntilCorrect() {
        isForceUntilCorrect = !isForceUntilCorrect;
        System.out.println(bundle.getString("forceUntilCorrect.mode.changed") + (isForceUntilCorrect
                ? bundle.getString("forceUntilCorrect.mode.on") : bundle.getString("forceUntilCorrect.mode.off")));
        Menu.menu();
    }

    private static void changeTable(Operation operation) {
        boolean isEqualsAdd = operation.equals(Operation.ADD);

        String message = operation.getMessage();

        System.out.printf(bundle.getString("current.table"), table);
        System.out.printf(bundle.getString("change.table.prompt"), message);
        String userInput = scanner.nextLine();

        if (!isValidNumber(userInput)) {
            Menu.menu();
            return;
        }

        int number = Integer.parseInt(userInput);

        if (number < 1 || number > 10) {
            System.out.println(bundle.getString("number.out.of.range"));
            returnToMenuChangeTable(operation);
            return;
        }

        if (isEqualsAdd ? table.add(number) : table.remove(number)) {
            String messagePast = isEqualsAdd
                    ? bundle.getString("add.past.version")
                    : bundle.getString("remove.past.version");

            System.out.printf(bundle.getString("number.successfully.operation"), number, messagePast);
        } else {
            System.out.printf(bundle.getString("number.error.message"),
                    message, number, isEqualsAdd ? bundle.getString("number.already.present")
                            : bundle.getString("number.absent"));
        }

        returnToMenuChangeTable(operation);
    }

    private static void presets() {
        System.out.println(bundle.getString("presets.text"));

        System.out.print(bundle.getString("presets.prompt"));
        String option = scanner.nextLine();

        switch (option) {
            case "1" -> {
                table.clear();
                table.addAll(Set.of(6, 7, 8, 9));
                System.out.printf(bundle.getString("presets.applied"), option);
            }
            case "2" -> {
                table.clear();
                table.addAll(Set.of(3, 4, 6, 7, 8, 9));
                System.out.printf(bundle.getString("presets.applied"), option);
            }
            case "3" -> {
                table.clear();
                table.addAll(Set.of(2, 3, 4, 5, 6, 7, 8, 9));
                System.out.printf(bundle.getString("presets.applied"), option);
            }
            case "4" -> {
                table.clear();
                table.addAll(Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
                System.out.printf(bundle.getString("presets.applied"), option);
            }
            case "5" -> {
                checkCurrentPreset();
                return;
            }
            case "6" -> {
                createCustomPreset();
                return;
            }
            default -> {
                Menu.menu();
                return;
            }
        }

        System.out.printf(bundle.getString("updated.table"), table);
    }


    private static void checkScore() {
        System.out.println(bundle.getString("current.score") + score);
        Menu.menu();
    }

    private static void resetScore() {
        score = 0;
        System.out.println(bundle.getString("reset.score") + score);
        Menu.menu();
    }

    private static void checkCurrentPreset() {
        System.out.printf(bundle.getString("current.preset"), table);
    }

    private static void createCustomPreset() {
        System.out.println(bundle.getString("custom.preset.text"));

        Set<Integer> customPreset = new HashSet<>();

        while (true) {
            System.out.print(bundle.getString("preset.custom.prompt"));
            String userInput = scanner.nextLine().trim();

            if (userInput.equalsIgnoreCase("done")) {
                break;
            }

            String[] userNumbers = userInput.split("\\s+");

            for (String userNumber : userNumbers) {
                try {
                    int number = Integer.parseInt(userNumber.trim());
                    if (number < 1 || number > 10) {
                        System.out.println(bundle.getString("number.out.of.range"));
                        break;
                    }
                    customPreset.add(number);
                } catch (NumberFormatException e) {
                    System.out.println(bundle.getString("preset.custom.invalid"));
                    break;
                }
            }
        }

        if (customPreset.isEmpty()) {
            System.out.println(bundle.getString("preset.custom.empty") + table);
            return;
        }

        table.clear();
        table.addAll(customPreset);

        System.out.printf(bundle.getString("preset.custom.success"), table);
    }

    private enum Operation {
        ADD(bundle.getString("add")),
        REMOVE(bundle.getString("remove"));

        private final String message;

        Operation(String message) {
            this.message = message;
        }

        private String getMessage() {
            return message;
        }
    }

    private static void returnToMenuChangeTable(Operation operation) {
        System.out.printf(bundle.getString("updated.table"), table);
        System.out.print(bundle.getString("return.menu"));
        String userAnswer = scanner.nextLine().trim();

        if (userAnswer.equalsIgnoreCase("y")) {
            Menu.menu();
        } else {
            changeTable(operation);
        }
    }

    private static boolean isValidNumber(String userInput) {
        try {
            Integer.parseInt(userInput);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static void leave() {
        isPlaying = false;
    }

    private static int chooseRandom(Set<Integer> table) {
        List<Integer> tableList = new ArrayList<>(table);
        return tableList.get(random.nextInt(tableList.size()));
    }
}
