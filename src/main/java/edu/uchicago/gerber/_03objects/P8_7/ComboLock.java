package edu.uchicago.gerber._03objects.P8_7;

public class ComboLock {
    private int secret1;
    private int secret2;
    private int secret3;
    private int dialPosition;
    private boolean firstTurnRight;
    private boolean secondTurnLeft;
    private boolean thirdTurnRight;

    public ComboLock(int secret1, int secret2, int secret3) {
        this.secret1 = secret1;
        this.secret2 = secret2;
        this.secret3 = secret3;
        reset();
    }

    public void reset() {
        dialPosition = 0;
        firstTurnRight = false;
        secondTurnLeft = false;
        thirdTurnRight = false;
    }

    public void turnLeft(int ticks) {
        dialPosition -= ticks;
        dialPosition %= 40;

        if (dialPosition < 0) {
            dialPosition += 40;
        }
        //System.out.println(dialPosition);
        if (firstTurnRight && dialPosition == secret2) {
            secondTurnLeft = true;
        }
    }

    public void turnRight(int ticks) {
        dialPosition += ticks;
        dialPosition %= 40;
        //System.out.println(dialPosition);
        if (!firstTurnRight && dialPosition == secret1) {
            firstTurnRight = true;
        } else if (secondTurnLeft && dialPosition == secret3) {
            thirdTurnRight = true;
        }
    }

    public boolean open() {
        if (!firstTurnRight || !secondTurnLeft || !thirdTurnRight) {
            reset();
            return false;
        }
        reset();
        return true;
    }
}
