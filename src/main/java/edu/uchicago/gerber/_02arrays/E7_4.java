package edu.uchicago.gerber._02arrays;

import java.io.*;

public class E7_4 {
//    A program that reads a file containing text. Read each line and send it to the output file, preceded by line numbers.
//    To run the code, the file should be placed in the same directory as the code. Input "mary.txt" to test
    public static void main(String[] args) {
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            // Prompt the user for input and output file names
            String inputFileName = getInputFileNameFromUser();
            String outputFileName = getOutputFileNameFromUser();

            // Create reader and writer objects
            String root = System.getProperty("user.dir");
            String inputFilePath = root+ File.separator+"src\\main\\java\\edu\\uchicago\\gerber\\_02arrays"+File.separator+inputFileName;
            reader = new BufferedReader(new FileReader(inputFilePath));
            String outputFilePath = root+ File.separator+"src\\main\\java\\edu\\uchicago\\gerber\\_02arrays"+File.separator+outputFileName;
            writer = new BufferedWriter(new FileWriter(outputFilePath));

            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                // Write the line number and the line itself to the output file
                writer.write("/* " + lineNumber + " */ " + line);
                writer.newLine();
                lineNumber++;
            }
            System.out.println("File successfully processed!");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("An error occurred while closing the file: " + e.getMessage());
            }
        }
    }

    private static String getInputFileNameFromUser() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the input file name: ");
        return reader.readLine();
    }
    private static String getOutputFileNameFromUser() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the output file name: ");
        return reader.readLine();
    }
}
