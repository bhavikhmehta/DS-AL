package com.bhavik;

/*
    One Away: There are three types of edits that can be performed on strings: insert
    a character, remove a character, or replace a character. Given two strings, write
    a function to check if they are one edit (or zero edits) away.
 */

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(oneEdit("pale", "ple"));
        System.out.println(oneEdit("pales", "pale"));
        System.out.println(oneEdit("pale", "bale"));
        System.out.println(oneEdit("pale", "bake"));
    }


    public static boolean oneEdit(String originalWord, String editWord) {

        boolean oneEdit = false;
        //multiple edit
        if (Math.abs(originalWord.length() - editWord.length()) >= 2) {
            return false;
        } else {
            HashMap<Character, Integer> charMap = new HashMap <Character, Integer>();

            for (char c: originalWord.toCharArray()) {
                charMap.put(c, charMap.getOrDefault(c, 0) + 1);
            }

            for (char c: editWord.toCharArray()) {

                if (!charMap.containsKey(c)) {
                    if (!oneEdit) {
                        oneEdit = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
