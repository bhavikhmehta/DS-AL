package com.company;

import java.util.HashMap;

public class Main {

    /*
        String Rotation: Assume you have a method isSubstring which checks if one word is a substring of another.
        Given two strings, 51 and 52, write code to check if 52 is a rotation of 51
        using only one call to isSubstring (e.g., "waterbottle" is a rotation of "erbottlewat").
    */
    public static void main(String[] args) {
	// write your code here
        //waterbottlewaterbottle
        System.out.println(isRotation("waterbottle", "erbottltewa")); //false
        System.out.println(isRotation("waterbottle", "bottlewater")); //true
    }


    public static boolean isRotation(String s1, String s2) {

        if (s1.length() == s2.length() && s1.length() > 0) {
            //Contains all rotations of string when added together
            s1 = s1 + s1;
            return isSubstring(s1, s2);

        } else {

            return false;
        }
    }

    public static boolean isSubstring(String s1, String s2) {

        if (s1.contains(s2)) {

            return true;
        }

        return false;
    }
}
