package edu.uchicago.gerber._07streams;

public class YodaSpeakRecursive {
    public static void main(String[] args) {
        String sentence = "The force is strong with you";
        String reversedSentence = reverseWordsRecursive(sentence);
        System.out.println(reversedSentence);

        // Testing the reverseWordsRecursive method with another sentence
        String testSentence = "May the force be with you";
        String reversedTestSentence = reverseWordsRecursive(testSentence);
        System.out.println(reversedTestSentence);
    }

    public static String reverseWordsRecursive(String sentence) {
        if (sentence.isEmpty()) {
            return sentence;
        } else {
            int lastSpace = sentence.lastIndexOf(' ');
            if (lastSpace == -1) {
                return sentence;
            } else {
                return sentence.substring(lastSpace + 1) + " " + reverseWordsRecursive(sentence.substring(0, lastSpace));
            }
        }
    }
}
