package org.example;

import java.util.*;

public class GameLogic {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static final Set<Integer> table = new HashSet<>(List.of(2, 3, 4, 5, 9));
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

        System.out.print(num1 + " * " + num2 + "? ");
        String userAnswer = scanner.nextLine();

        try {
            Integer.parseInt(userAnswer);
        } catch (NumberFormatException e) {
            leave();
            System.out.println("Your final score: " + score);
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
        System.out.println("1. Add numbers in multiplication table");
        System.out.println("2. Remove numbers in multiplication table");
        System.out.println("3. Back menu");
        System.out.print("Type your option here: ");
        String option = scanner.nextLine();

        switch (option) {
            case "1" -> addNumbersInMultiplicationTable();
            case "2" -> removeNumbersInMultiplicationTable();
            default -> {
                Menu.menu();
            }
        }
    }

    public static void addNumbersInMultiplicationTable() {
        }
    }

    public static void removeNumbersInMultiplicationTable() {

    }

    public static void leave() {
        playing = false;
    }

    public static int chooseRandom(Set<Integer> tables) {
        List<Integer> tableList = new ArrayList<>(tables);
        return tableList.get(random.nextInt(tableList.size()));
    }
}
