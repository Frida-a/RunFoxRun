package edu.uchicago.gerber._04interfaces.P9_6;

class Monthly extends Appointment {
    public Monthly(String description, int year, int month, int day) {
        super(description, year, month, day);
    }

    @Override
    public boolean occursOn(int year, int month, int day) {
        return (this.day == day); // Monthly appointment occurs on the specific day every month
    }
}
