package com.company;

public class Main {

    /*
    Given a string, find the length of the longest substring without repeating characters.

    Examples:
    Given "abcabcbb", the answer is "abc", which the length is 3.
    Given "bbbbb", the answer is "b", with the length of 1.
    Given "pwwkew", the answer is "wke", with the length of 3.
     */
    public static void main(String[] args) {
	// write your code here

        System.out.println(longestSubtring("abcabcbb"));
        System.out.println(longestSubtring("bbbbb"));
        System.out.println(longestSubtring("pwwkew"));

    }

    public static String longestSubtring(String word){

        String currentSub = "";
        String longestSub = "";

        for (int i = 0; i < word.length(); i++) {

            if (currentSub.indexOf(word.charAt(i)) == -1) { //this line

                currentSub += "" + word.charAt(i);
            } else {

                if (currentSub.length() > longestSub.length()) {
                    longestSub = currentSub;
                }
                currentSub = "" + word.charAt(i);
            }
        }
        return longestSub;
        //return longestSub.length(); <- to return the size of the the substring
    }
}
