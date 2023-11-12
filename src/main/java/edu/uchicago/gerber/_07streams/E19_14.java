package edu.uchicago.gerber._07streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class E19_14 {
    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        String filename = "warandpeace.txt";
        String currentPath = Paths.get("").toAbsolutePath().toString();
        String filePath = currentPath + "/src/main/java/edu/uchicago/gerber/_07streams/" + filename;

        try {
            // Read all words from the file into an ArrayList
            wordList = Files.readAllLines(Paths.get(filePath));
            wordList.parallelStream()
                    .filter(word -> word.length() >= 5 && isPalindrome(word))
                    .findAny()
                    .ifPresent(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isPalindrome(String word) {
        return word.equalsIgnoreCase(new StringBuilder(word).reverse().toString());
    }
}
//When you run this program multiple times, it's possible that the result might be different each time.
