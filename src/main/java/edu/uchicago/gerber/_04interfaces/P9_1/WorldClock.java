package edu.uchicago.gerber._04interfaces.P9_1;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
public class WorldClock extends Clock {
    private int timeOffset;

    public WorldClock(int timeOffset) {
        this.timeOffset = timeOffset;
    }

    @Override
    public int getHours() {
        LocalTime localTime = LocalTime.now(ZoneId.ofOffset("UTC", ZoneOffset.ofHours(timeOffset)));
        return localTime.getHour();
    }

    @Override
    public int getMinutes() {
        LocalTime localTime = LocalTime.now(ZoneId.ofOffset("UTC", ZoneOffset.ofHours(timeOffset)));
        return localTime.getMinute();
    }
}

