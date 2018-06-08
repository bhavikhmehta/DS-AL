package com.bhavik;

/*
    String Compression: Implement a method to perform basic string
    compression using the counts of repeated characters. For example, the string
    aabcccccaaa would become a2blc5a3. If the "compressed" string would not
    become smaller than the original string, your method should return the original
    string. You can assume the string has only uppercase and lowercase letters (a - z).
*/

public class Main {

    public static void main(String[] args) {
	// write your code here
       System.out.println(stringCompress("b"));
       System.out.println(stringCompress("aabcccccaaa"));
    }

    public static String stringCompress(String word) {

        int countLetter = 0;
        char currentLetter;
        StringBuilder newWord = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            currentLetter = word.charAt(i);
            countLetter++;

            if (i + 1 == word.length() || currentLetter != word.charAt(i + 1)) {

                newWord.append(currentLetter);
                newWord.append(countLetter);
                countLetter = 0;
            }
        }

        if (newWord.length() > word.length()) {

            return word.toString();
        } else {

            return newWord.toString();
        }
    }
}
