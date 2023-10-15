package edu.uchicago.gerber._03objects.P8_7;


public class Driver {
    public static void main(String[] args) {
        ComboLock myLock = new ComboLock(1,2,3);
        myLock.turnRight(1);
        myLock.turnLeft(39);
        myLock.turnRight(41);
        System.out.println(myLock.open());

        myLock.reset();
        myLock.turnRight(1);
        myLock.turnRight(1);
        myLock.turnRight(1);
        System.out.println(myLock.open());
    }
}
