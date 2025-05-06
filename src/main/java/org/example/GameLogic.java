package org.example;

import java.util.*;

public class GameLogic {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static final Set<Integer> table = new HashSet<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    private static boolean playing = true;
    private static boolean forceUntilCorrect = false;
    private static int score;

    public static void operateOption(String option) {
        while (playing) {
            switch (option) {
                case "1" -> play();
                case "2" -> configure();
                default -> {
                    leave();
                }
            }
        }
    }

    public static void play() {
        if (table.isEmpty()) {
            System.out.println("Please select or create a preset");
            presets();
            return;
        }

        int num1 = chooseRandom(table);
        int num2 = chooseRandom(table);

        int correctAnswer = num1 * num2;

        while (true) {
            System.out.printf("%d * %d ? ", num1, num2);
            String userAnswer = scanner.nextLine();

            if (!isValidNumber(userAnswer)) {
                System.out.println("Your final score: " + score);
                Menu.menu();
                return;
            }

            if (userAnswer.equals(String.valueOf(correctAnswer))) {
                score++;
                System.out.println("Correct!");
                break;
            } else {
                System.out.println("Wrong!");
                if (!forceUntilCorrect) {
                    break;
                }
            }
        }
    }

    public static void configure() {
        System.out.println("""
            =========================================
                            Configure
            =========================================
            1. Presets
            2. Add numbers in multiplication table
            3. Remove numbers in multiplication table
            4. Toggle "Answer until correct" (Currently: %s)
            5. Return menu
            """.formatted(forceUntilCorrect ? "TRUE" : "FALSE"));
        System.out.print("Type your option here: ");
        String option = scanner.nextLine();

        switch (option) {
            case "1" -> presets();
            case "2" -> changeTable(Operation.ADD);
            case "3" -> changeTable(Operation.REMOVE);
            case "4" -> toggleAnswerUntilCorrect();
            default -> Menu.menu();
        }
    }

    private static void toggleAnswerUntilCorrect() {
        forceUntilCorrect = !forceUntilCorrect;
        System.out.println("Answer Until Correct is now set to: " + (forceUntilCorrect ? "TRUE" : "FALSE"));
        Menu.menu();
    }

    private static void changeTable(Operation operation) {
        boolean isEqualsAdd = operation.equals(Operation.ADD);

        String message = operation.getMessage();

        System.out.printf("The current multiplication table is: %s%n%n", table);
        System.out.printf("Type here the number you want to %s (1 to 10) or any letter to return menu: ", message);
        String userInput = scanner.nextLine();

        if (!isValidNumber(userInput)) {
            Menu.menu();
            return;
        }

        int number = Integer.parseInt(userInput);

        if (number < 1 || number > 10) {
            System.out.println("Number must be between 1 and 10");
            returnToMenuChangeTable(operation);
            return;
        }

        if (isEqualsAdd ? table.add(number) : table.remove(number)) {
            System.out.printf("Number '%d' successfully %s.%n", number, message);
        } else {
            System.out.printf("You can't %s number '%d'. It is %s in the table.%n",
                    message, number, isEqualsAdd ? "already present" : "absent");
        }

        returnToMenuChangeTable(operation);
    }

    private static void presets() {
        System.out.println("""
                ===================================
                              Presets
                ===================================
                1. Include only [6, 7, 8, 9]
                2. Include only [3, 4, 6, 7, 8, 9]
                3. Include only [2, 3, 4, 5, 6, 7, 8, 9]
                4. Include all [1 to 10]
                5. Check current preset
                6. Create custom preset
                7. Return menu
                """);

        System.out.print("Type your option here: ");
        String option = scanner.nextLine();

        switch (option) {
            case "1" -> {
                table.clear();
                table.addAll(Set.of(6, 7, 8, 9));
                System.out.println("Preset 1 applied.");
            }
            case "2" -> {
                table.clear();
                table.addAll(Set.of(3, 4, 6, 7, 8, 9));
                System.out.println("Preset 2 applied.");
            }
            case "3" -> {
                table.clear();
                table.addAll(Set.of(2, 3, 4, 5, 6, 7, 8, 9));
                System.out.println("Preset 3 applied.");
            }
            case "4" -> {
                table.clear();
                table.addAll(Set.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
                System.out.println("Preset 4 applied.");
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

        System.out.printf("Updated table: %s%n", table);
    }

    private static void checkCurrentPreset() {
        System.out.printf("Current preset: %s%n", table);
    }

    private static void createCustomPreset() {
        System.out.println("""
            =============================================================
                                    Custom Preset
            =============================================================
            Type the numbers you want to include in your preset (1 to 10),
            separated by spaces (ex: '1 2 6 10' or '4 9' or '5'):
            Type 'done' when you finish.
            """);

        String userInput;
        Set<Integer> customPreset = new HashSet<>();
        boolean isValidInput = true;

        while (true) {
            System.out.print("Enter numbers or 'done' to finish: ");
            userInput = scanner.nextLine().trim();

            if (userInput.equalsIgnoreCase("done")) {
                break;
            }

            String[] userNumbers = userInput.split("\\s+");

            for (String userNumber : userNumbers) {
                try {
                    int number = Integer.parseInt(userNumber.trim());
                    if (number < 1 || number > 10) {
                        System.out.println("Number must be between 1 and 10. Please try again.");
                        isValidInput = false;
                        break;
                    }
                    customPreset.add(number);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input, please enter only numbers separated by spaces.");
                    isValidInput = false;
                    break;
                }
            }

            if (!isValidInput) {
                customPreset.clear();
                continue;
            }
        }

        table.clear();
        table.addAll(customPreset);

        System.out.printf("Custom preset applied. Updated table: %s%n", table);
    }

    private enum Operation {
        ADD("add"),
        REMOVE("remove");

        private final String message;

        Operation(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    private static void returnToMenuChangeTable(Operation operation) {
        System.out.printf("Updated table: %s%n%n", table);
        System.out.print("Return to menu? (Y/N) ");
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

    public static void leave() {
        playing = false;
    }

    private static int chooseRandom(Set<Integer> table) {
        List<Integer> tableList = new ArrayList<>(table);
        return tableList.get(random.nextInt(tableList.size()));
    }
}
