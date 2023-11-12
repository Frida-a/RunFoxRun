package edu.uchicago.gerber._07streams;
import java.util.Arrays;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class E19_16 {
    public static void main(String[] args) {
        String filename = "warandpeace.txt";
        String currentPath = Paths.get("").toAbsolutePath().toString();
        String filePath = currentPath + "/src/main/java/edu/uchicago/gerber/_07streams/" + filename;

        try {
            // Read all words in the file, group them by the first letter in lowercase and print the average word length for each initial letter
            Files.lines(Paths.get(filePath))
                    .map(line -> line.split("\\s+"))
                    .flatMap(Arrays::stream)
                    .filter(word -> !word.isEmpty())
                    .collect(Collectors.groupingBy(word -> word.toLowerCase().charAt(0),
                            Collectors.averagingInt(String::length)))
                    .forEach((letter, averageLength) -> System.out.println(letter + ": " + averageLength));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

