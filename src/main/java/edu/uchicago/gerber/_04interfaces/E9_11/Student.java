package edu.uchicago.gerber._04interfaces.E9_11;

class Student extends Person {
    private String major;

    public Student(String name, int yearOfBirth, String major) {
        super(name, yearOfBirth);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public String toString() {
        return super.toString() + ", Major: " + major;
    }
}
