package org.example.refactor;

import java.util.Scanner;

public class Game {
    private final GameState gameState;
    private final Menu menu;
    private final GameService gameService;

    public Game() {
        Scanner scanner = new Scanner(System.in);
        this.gameState = new GameState();
        this.gameService = new GameService(scanner, gameState);
        this.menu = new Menu(scanner, gameState, gameService);
    }

    public void start() {
        System.out.println("IF YOU WANT TO CANCEL AN OPERATION OR GO BACK TO MENU TYPE ANY LETTER");

        while (gameState.isPlaying()) {
            menu.initial();
        }
    }
}
