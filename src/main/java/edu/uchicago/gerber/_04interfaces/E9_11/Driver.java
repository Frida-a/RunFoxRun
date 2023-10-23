package edu.uchicago.gerber._04interfaces.E9_11;

public class Driver {
    public static void main(String[] args) {
        Student student = new Student("John Doe", 1998, "Computer Science");
        Instructor instructor = new Instructor("Jane Smith", 1980, 50000.0);

        System.out.println("Student: " + student.toString());
        System.out.println("Instructor: " + instructor.toString());
    }
}
