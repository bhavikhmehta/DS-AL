package com.company;

/*
    Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the
    image is 4 bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 */
public class Main {
    /*
        Steps to rotate matrix 90 degrees:

        First transpose matrix (row elements become column elements)
        If clockwise rotation: reverse column elements for each row (same as reversing a 1D array)
        If counter clockwise rotation: reverse each row
     */
    public static void main(String[] args) {
	// write your code here

        int [] [] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        rotateMatrix(matrix);
    }

    public static int[] [] rotateMatrix(int[] [] originalMatrix) {

        System.out.println("Original Matrix");
        printMatrix(originalMatrix);
        int [] [] transposeMatrix = transposeMatrix(originalMatrix);

        clockwiseRotation(transposeMatrix);
        counterRotation(transposeMatrix);


        return originalMatrix;
    }


    public static int[] [] transposeMatrix( int[] [] originalMatrix) {

        int [] [] transposeMatrix = new int[originalMatrix.length][originalMatrix.length];
        for (int row = 0; row < originalMatrix.length; row++) {
            for (int col = 0; col < originalMatrix.length; col++) {
                 transposeMatrix[row] [col]= originalMatrix[col][row];
            }
        }

        return transposeMatrix;
    }


    private static void clockwiseRotation(int[][] transposeMatrix) {

        for (int row = 0; row < transposeMatrix.length; row++) {
            for (int col = 0; col < transposeMatrix.length / 2; col++) {

                int temp = transposeMatrix[row] [col];
                transposeMatrix[row] [col] = transposeMatrix[row][transposeMatrix.length - col -1];
                transposeMatrix[row][transposeMatrix.length - col -1] = temp;
            }
        }
        System.out.println("Clockwise Rotation");
        printMatrix(transposeMatrix);
    }

    private static void counterRotation(int[][] transposeMatrix) {
        for (int row = 0; row < transposeMatrix.length / 2; row++) {
            for (int col = 0; col < transposeMatrix.length; col++) {
                int [] temp = transposeMatrix[row];
                transposeMatrix[row] = transposeMatrix[transposeMatrix.length - row - 1];
                transposeMatrix[transposeMatrix.length - row - 1] = temp;
            }
        }

        System.out.println("Counter Clockwise Rotation");
        printMatrix(transposeMatrix);
    }

    public static void printMatrix(int[] [] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
                System.out.print(" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

}
