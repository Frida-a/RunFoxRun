package edu.uchicago.gerber._04interfaces.P9_6;

public class Appointment {
    protected String description;
    protected int year;
    protected int month;
    protected int day;

    public Appointment(String description, int year, int month, int day) {
        this.description = description;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean occursOn(int year, int month, int day) {
        return (this.year == year && this.month == month && this.day == day);
    }

    public String getDescription() {
        return description;
    }
}
