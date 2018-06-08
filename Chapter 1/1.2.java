package com.bhavik;

import java.util.HashMap;

/*
    Check Permutation: Given two strings, write a method to decide if
    one is a permutation of the other.
 */
public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println(isPermutation("hello","ellos"));
        System.out.println(isPermutation("What A Time To Be Alive","Alive To Be A Time What"));
    }


    public static boolean isPermutation(String word1, String word2) {
        /*
            Strings can be be converted to all lower case for non case sensitive
            permutations.
            In this implementation it is not considered.
         */
        if (word1.length() != word2.length()) {

            return false;
        } else {

            //key value pair
            HashMap<Character, Integer> wordMap = new HashMap<Character, Integer>();

            for (Character c: word1.toCharArray()) {
                if (!wordMap.containsKey(c)) {

                    wordMap.put(c, 1);
                } else {

                    wordMap.put(c, wordMap.get(c) + 1);
                }
            }

            for (Character c: word2.toCharArray()) {
                if (!wordMap.containsKey(c)) {

                    return false;
                } else {

                    wordMap.put(c, wordMap.get(c) - 1);
                }
            }

            for (Character c: wordMap.keySet()) {

                if (wordMap.get(c) != 0) {
                    return false;
                }
            }
        }

        return true;
    }
}
