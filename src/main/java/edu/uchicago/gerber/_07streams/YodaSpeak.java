package edu.uchicago.gerber._07streams;

import java.util.*;

public class YodaSpeak {
    public static void main(String[] args) {
        String sentence = "The force is strong with you";
        String reversedSentence = reverseWords(sentence);
        System.out.println(reversedSentence);

        // Testing the reverseWords method with another sentence
        String testSentence = "May the force be with you";
        String reversedTestSentence = reverseWords(testSentence);
        System.out.println(reversedTestSentence);
    }

    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder reversedSentence = new StringBuilder();

        for (int i = words.length - 1; i > 0; i--) {
            reversedSentence.append(words[i]).append(" ");
        }
        reversedSentence.append(words[0]);

        return reversedSentence.toString();
    }
}

