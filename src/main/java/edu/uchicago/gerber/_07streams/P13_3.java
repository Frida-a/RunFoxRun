package edu.uchicago.gerber._07streams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P13_3 {
    private static final Map<Character, String> phonePadLetters = new HashMap<Character, String>() {{
        put('2', "ABC");
        put('3', "DEF");
        put('4', "GHI");
        put('5', "JKL");
        put('6', "MNO");
        put('7', "PQRS");
        put('8', "TUV");
        put('9', "WXYZ");
    }};
    private static List<String> validWords;
    private static List<String> validSequences;

    public static void main(String[] args) {
        String phoneNumber = "2633465282";
        List<String> wordSequences = letterCombinations(phoneNumber);
        System.out.println("Word sequences for " + phoneNumber + ": " + wordSequences);
    }

    public static List<String> letterCombinations(String digits) {
        validWords = new ArrayList<>();
        validSequences = new ArrayList<>();
        constructValidWords();
        findWordSequences(digits, 0, "", "");
        return validSequences;
    }

    private static void constructValidWords() {
        validWords.add("COD");
        validWords.add("CODE");
        validWords.add("IN");
        validWords.add("JAVA");
    }

    private static void findWordSequences(String digits, int index, String currentSequence, String currentWord) {
        if (index == digits.length()) {
            if (!currentWord.isEmpty() && validWords.contains(currentWord)) {
                validSequences.add(currentSequence.trim());
            }
            return;
        }

        char digit = digits.charAt(index);
        String letters = phonePadLetters.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            String newSequence = currentSequence + letters.charAt(i);
            String newWord = currentWord + letters.charAt(i);
            if (validWords.contains(newWord)) {
                findWordSequences(digits, index + 1, newSequence + " ", "");
            }
            findWordSequences(digits, index + 1, newSequence, newWord);
        }
    }
}

