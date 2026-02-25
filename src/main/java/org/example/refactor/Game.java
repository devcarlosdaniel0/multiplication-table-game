package org.example.refactor;

public class Game {
    private final GameState gameState;
    private final Menu menu;
    private final GameService gameService;

    public Game() {
        this.gameState = new GameState();
        this.menu = new Menu(gameState);
        this.gameService = new GameService(gameState, menu);
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
