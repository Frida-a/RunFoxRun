package edu.uchicago.gerber._04interfaces.E9_11;

class Person {
    private String name;
    private int yearOfBirth;

    public Person(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public String getName() {
        return name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public String toString() {
        return "Name: " + name + ", Year of Birth: " + yearOfBirth;
    }
}
