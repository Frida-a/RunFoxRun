package edu.uchicago.gerber._06design.E12_4;
import java.util.Scanner;

public class Player {
    private Scanner scanner = new Scanner(System.in);
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {
        score++;
    }

    public int getInput() {
        System.out.print("Enter your answer: ");
        return scanner.nextInt();
    }
}


