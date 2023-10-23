package edu.uchicago.gerber._04interfaces.P9_1;
import java.time.LocalTime;

public class Clock {
    public int getHours() {
        return LocalTime.now().getHour();
    }

    public int getMinutes() {
        return LocalTime.now().getMinute();
    }

    public String getTime() {
        int hours = getHours();
        int minutes = getMinutes();
        return String.format("%02d:%02d", hours, minutes);
    }
}

