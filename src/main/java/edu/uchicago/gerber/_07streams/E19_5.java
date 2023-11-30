package edu.uchicago.gerber._07streams;

import java.util.stream.*;
import java.util.*;

public class E19_5 {
    public static void main(String[] args) {
        // Test the method
        Stream<Integer> intStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(toString(intStream, 5));  // Output: "1, 2, 3, 4, 5"

        Stream<String> strStream = Stream.of("apple", "banana", "cherry", "date", "elderberry");
        System.out.println(toString(strStream, 3));  // Output: "apple, banana, cherry"
    }

    public static <T> String toString(Stream<T> stream, int n) {
        List<T> firstNElements = stream.limit(n).collect(Collectors.toList());
        return firstNElements.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}

