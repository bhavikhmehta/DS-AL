package com.bhavik;

import java.util.HashSet;

/*
    Is Unique: Implement an algorithm to determine if a string has all
    unique characters. What if you cannot use additional data structures?
*/
public class Main {

    public static void main(String[] args) {
        System.out.println(isUnique("What"));
        System.out.println(isUnique("Hello"));
        System.out.println(isUnique("each"));
        System.out.println(isUnique("What a time to be alive"));
    }


    public static boolean isUnique(String word) {
        HashSet characterMap = new HashSet();

        for (char c: word.toCharArray()) {
            if (characterMap.contains(c)) {

                return false;
            } else {

                characterMap.add(c);
            }
        }

        return true;
    }
}
