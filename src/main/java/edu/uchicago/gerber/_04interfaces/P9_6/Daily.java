package edu.uchicago.gerber._04interfaces.P9_6;

class Daily extends Appointment {
    public Daily(String description, int year, int month, int day) {
        super(description, year, month, day);
    }

    @Override
    public boolean occursOn(int year, int month, int day) {
        return true; // Daily appointment occurs every day
    }
}
