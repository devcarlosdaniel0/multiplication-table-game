package org.example;

import java.util.*;

public class GameLogic {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static final Set<Integer> table = new HashSet<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    private static boolean playing = true;
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
        int num1 = chooseRandom(table);
        int num2 = chooseRandom(table);

        int correctAnswer = num1 * num2;

        System.out.printf("%d * %d ? ", num1, num2);
        String userAnswer = scanner.nextLine();

        if (!isValidNumber(userAnswer)) {
            System.out.println("Your final score: " + score);
            leave();
            return;
        }

        if (userAnswer.equals(String.valueOf(correctAnswer))) {
            score++;
            System.out.println("Correct!");
        } else {
            System.out.println("Wrong!");
        }
    }

    public static void configure() {
        System.out.println("""
            =========================================
                            Configure
            =========================================
            1. Add numbers in multiplication table
            2. Remove numbers in multiplication table
            3. Presets
            4. Check current preset
            5. Return menu
            """);
        System.out.print("Type your option here: ");
        String option = scanner.nextLine();

        switch (option) {
            case "1" -> changeTable(Operation.ADD);
            case "2" -> changeTable(Operation.REMOVE);
            case "3" -> presets();
            case "4" -> checkCurrentPreset();
            default -> Menu.menu();
        }
    }

    private static void changeTable(Operation operation) {
        boolean isEqualsAdd = operation.equals(Operation.ADD);

        String message = operation.getMessage();

        System.out.printf("The current multiplication table is: %s%n%n", table);
        System.out.printf("Type here the number you want to %s (1 to 10) or any letter to return menu: ", message);
        String userNumber = scanner.nextLine();

        if (!isValidNumber(userNumber)) {
            Menu.menu();
            return;
        }

        int number = Integer.parseInt(userNumber);

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

    public static void presets() {
        System.out.println("""
                ===================================
                              Presets
                ===================================
                1. Include [6, 7, 8, 9]
                2. Include [3, 4, 6, 7, 8, 9]
                3. Include [2, 3, 4, 5, 6, 7, 8, 9]
                4. Include all [1 to 10]
                5. Return menu
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
