package edu.uchicago.gerber._06design.E12_4;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        Level level = new Level(1);
        Player player = new Player(playerName);
        ArithmeticProblem problem = new ArithmeticProblem();

        while (level.getLevelNumber() < 4) {
            String arithmeticProblem = problem.generateProblem(level);
            System.out.println("Level " + level.getLevelNumber() + ": Solve the problem - " + arithmeticProblem);

            int userAnswer = player.getInput();
            int correctAnswer = evaluateProblem(arithmeticProblem);

            if (userAnswer == correctAnswer) {
                System.out.println("Correct!");
                player.incrementScore();
                if (player.getScore() == 5 * level.getLevelNumber()) {
                    level = new Level(level.getLevelNumber() + 1);
                }
            } else {
                System.out.println("Incorrect answer. Try again!");

                // Allow the user one more attempt
                userAnswer = player.getInput();
                if (userAnswer == correctAnswer) {
                    System.out.println("Correct!");
                    player.incrementScore();
                    if (player.getScore() == 5 * level.getLevelNumber()) {
                        level = new Level(level.getLevelNumber() + 1);
                    }
                } else {
                    System.out.println("Incorrect answer!");
                }
            }
            System.out.println();
        }

        System.out.println("Congratulations, " + player.getName() + "! You have completed all levels!");
    }

    private static int evaluateProblem(String problem) {
        String[] operands = problem.split(" ");
        int operand1 = Integer.parseInt(operands[0]);
        int operand2 = Integer.parseInt(operands[2]);
        if (operands[1].equals("+")) {
            return operand1 + operand2;
        } else {
            return operand1 - operand2;
        }
    }
}
