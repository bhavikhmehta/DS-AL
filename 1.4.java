package com.company;


import java.util.HashMap;

/*
    Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
    A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement
    of letters.The palindrome does not need to be limited to just dictionary words.
 */
public class Main {


    public static void main(String[] args) {
	// write your code here
        System.out.println(isPalindromePermutation("what a time to be alive"));
        System.out.println(isPalindromePermutation("taco cat"));
    }


    public static boolean isPalindromePermutation(String word) {
        /*
            String with even length = characters must have an even count
            String with odd length = all characters except for one has an even count

            An even string can't have an odd number of exactly one character, otherwise it wouldn't be an even string
            An odd string can't have  all characters with an even count

            Thus, in both cases if there are more than one odd amount of characters, it is not a permutation of a
            palindome.
        */
        word = formatString(word);
        boolean isSingleLetter = false;
        HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();

        for (char c: word.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        for (char c: charMap.keySet()) {
            if (charMap.get(c) % 2 != 0) {
                if (!isSingleLetter) {
                    isSingleLetter = true;
                } else {
                    return false;
                }
            }
        }


        return true;
    }


    public static String formatString(String word) {
        //remove spacing
        //lower case letters
        //remove commas

        word = word.replaceAll(" ", "");
        word = word.toLowerCase();
        word = word.replaceAll(",", "");

        return word;
    }
}
