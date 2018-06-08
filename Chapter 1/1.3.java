package com.company;

/*
    URLify: Write a method to replace all spaces in a string with '%20: You may assume that the
    string has sufficient space at the end to hold the additional characters, and that you
    are given the "true" length of the string. (Note: If implementing in Java,
    please use a character array so that you can perform this operation in place.)
 */

public class Main {

    public static void main(String[] args) {
	// write your code here

        String url = "Mr John Smith";
        System.out.println(URLify(url.toCharArray()));
    }

    public static String URLify(char [] urlArr) {

        //true length + number of spaces between the string
        int index = urlArr.length - 1;
        int totalLength = (2 * numberOfSpaces(urlArr)) + index;
        urlArr = CopyArray(urlArr, totalLength);

        for (int i = index; i >= 0; i--) {
            if (urlArr[i] != ' ') {

                urlArr[totalLength] = urlArr[i];
                totalLength--;
            } else {

                urlArr[totalLength] = '0';
                urlArr[totalLength - 1] = '2';
                urlArr[totalLength - 2] = '%';
                totalLength = totalLength - 3;
            }
        }

        return String.valueOf(urlArr);
    }

    //Count number of spaces in array
    public static int numberOfSpaces(char [] urlArr) {
        int numberOfSpaces = 0;

        for (char c: urlArr) {
            if (c == ' ') {

                numberOfSpaces++;
            }
        }

        return numberOfSpaces;
    }

    //Copy original array into larger array to have space for %20
    public static char [] CopyArray(char [] urlArr, int length) {
        char [] arrayWithSpace = new char[length + 1];

        for (int i = 0; i < urlArr.length; i++) {
            arrayWithSpace[i] = urlArr[i];
        }

        return arrayWithSpace;
    }
}
