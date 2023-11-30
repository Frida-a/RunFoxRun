package edu.uchicago.gerber._07streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class E19_7 {
    public static void main(String[] args) {
        // Input words
        String[] words = {"Hello","a", "World", "Java", "Stream", "Lambda", "Function"};

        // Convert words array to a stream
        Stream<String> wordStream = Arrays.stream(words);

        wordStream.filter(word -> word.length() >= 2)
                .map(word -> word.substring(0, 1) + "..." + word.substring(word.length() - 1))
                .forEach(System.out::println);
    }
}

