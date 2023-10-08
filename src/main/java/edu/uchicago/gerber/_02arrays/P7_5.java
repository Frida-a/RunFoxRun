package edu.uchicago.gerber._02arrays;
import java.io.*;

public class P7_5 {
//    Write a CSVReader program that reads a CSV file, and provide methods
//    to run the code, place the CSV file in the same directory as the code, input "test.csv" to test, the test of the three functions are written hard code.
    private String[][] data;
    private int rows;
    private int columns;

    public P7_5(String filePath, char delimiter) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int row = 0;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(Character.toString(delimiter));
//                for (String field : fields) {
//                    System.out.println(field);
//                }
                if (data == null) {
                    columns = fields.length;
                    data = new String[10][columns]; // Assuming maximum of 10 rows initially
                }
                if (row >= data.length) expandData();
                System.arraycopy(fields, 0, data[row], 0, fields.length);
                row++;
            }
            rows = row;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int numberOfRows() {
        return rows;
    }

    public int numberOfFields(int row) {
        if (row >= 0 && row < rows) {
            return columns;
        }
        return 0;
    }

    public String field(int row, int column) {
        if (row >= 0 && row < rows && column >= 0 && column < columns) {
            return data[row][column];
        }
        return "";
    }

    private void expandData() {
        String[][] newData = new String[data.length * 2][columns];
        for (int i = 0; i < data.length; i++) {
            System.arraycopy(data[i], 0, newData[i], 0, columns);
        }
        data = newData;
    }

    private static String getInputFileNameFromUser() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter the input file name: ");
        return reader.readLine();
    }

    public static void main(String[] args) throws IOException {
        String inputFileName;
        inputFileName = getInputFileNameFromUser();
        String root = System.getProperty("user.dir");
        String inputFilePath = root+ File.separator+"src\\main\\java\\edu\\uchicago\\gerber\\_02arrays"+File.separator+inputFileName;
        P7_5 csvReader = new P7_5(inputFilePath, ',');
        System.out.println("Number of rows: " + csvReader.numberOfRows());
        System.out.println("Number of fields in row 0: " + csvReader.numberOfFields(0));
        System.out.println("Field at row 1, column 2: " + csvReader.field(1, 2));
    }
}
