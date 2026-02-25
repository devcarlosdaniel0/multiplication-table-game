package org.example.refactor;

import java.util.Scanner;

public class Game {
    private final GameState gameState;
    private final Menu menu;
    private final GameService gameService;

    public Game() {
        Scanner scanner = new Scanner(System.in);
        this.gameState = new GameState();
        this.menu = new Menu(scanner, gameState);
        this.gameService = new GameService(scanner, gameState, menu);
    }

    public void start() {
        while (gameState.isPlaying()) {
            String option = menu.showInitial();

            switch (option) {
                case "1" -> gameService.play();
                case "2" -> gameService.generalSettings();
                case "3" -> gameService.viewScore();

                default -> gameState.stop();
            }
        }
    }
}
