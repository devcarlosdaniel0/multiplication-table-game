package org.example.refactor;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class GameState {
    private boolean playing = true;
    private boolean randomRange = false;
    private Set<Integer> randomRangeInterval = new TreeSet<>();
    private int score = 0;
    private Set<Integer> numbers = new TreeSet<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

    public void stop() {
        playing = false;
    }

    public void incrementScore() {
        score++;
    }

    public void toggleRandomRange() {
        this.randomRange = !randomRange;
    }

    public boolean isPlaying() {
        return playing;
    }

    public int getScore() {
        return score;
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }

    public boolean isRandomRange() {
        return randomRange;
    }

    public Set<Integer> getRandomRangeInterval() {
        return randomRangeInterval;
    }
}
