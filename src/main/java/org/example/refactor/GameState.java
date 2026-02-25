package org.example.refactor;

import org.example.refactor.enums.MathOperation;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class GameState {
    private boolean playing = true;
    private boolean randomRange = false;
    private boolean answerUntilCorrect = false;
    private final Set<Integer> numbers = new TreeSet<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    private final Set<Integer> randomRangeInterval = new TreeSet<>();
    private int score = 0;
    private MathOperation mathOperation = MathOperation.MULTIPLY;

    public void stop() {
        playing = false;
    }

    public void incrementScore() {
        score++;
    }

    public void toggleRandomRange() {
        randomRange = !randomRange;
    }

    public void toggleAnswerUntilCorrect() {
        answerUntilCorrect = !answerUntilCorrect;
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

    public boolean isAnswerUntilCorrect() {
        return answerUntilCorrect;
    }

    public MathOperation getMathOperation() {
        return mathOperation;
    }

    public void setMathOperation(MathOperation mathOperation) {
        this.mathOperation = mathOperation;
    }
}
