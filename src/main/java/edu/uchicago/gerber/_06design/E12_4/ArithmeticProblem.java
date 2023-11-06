package edu.uchicago.gerber._06design.E12_4;
import java.util.Random;

public class ArithmeticProblem {
    private Random random = new Random();

    public String generateProblem(Level level) {
        if (level.getLevelNumber() == 1) {
            int num1 = random.nextInt(10);
            int num2 = random.nextInt(10 - num1);
            return num1 + " + " + num2;
        } else if (level.getLevelNumber() == 2) {
            int num1 = random.nextInt(10);
            int num2 = random.nextInt(10);
            return num1 + " + " + num2;
        } else if (level.getLevelNumber() == 3) {
            int num1 = random.nextInt(10);
            int num2 = random.nextInt(num1 + 1);
            return num1 + " - " + num2;
        }
        return "";
    }
}

