package edu.uchicago.gerber._06design.E12_4;

public class Level {
    private int levelNumber;
    private int score;

    public Level(int levelNumber) {
        this.levelNumber = levelNumber;
        this.score = 0;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        score++;
    }

    public boolean hasAchievedTargetScore() {
        return score == 5 * this.getLevelNumber();
    }
}

