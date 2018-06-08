package com.bhavik;

public class Main {

    /*
        Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0,
        its entire row and column are set to 0.
     */

    public static void main(String[] args) {
	// write your code here
        int [] [] matrix = {{1,2,8,4}, {5,0,7,8}, {3,4,0,1}};
        zeroMatrix(matrix);
    }

    //M x N matrix
    //M rows N columns
    public static void zeroMatrix(int[][] matrix) {
        printMatrix(matrix);

        boolean [] rowZero = new boolean[matrix.length];
        boolean [] colZero = new boolean[matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    rowZero[row] = true;
                    colZero[col] = true;
                }
            }
        }

        for (int r = 0; r < rowZero.length; r++) {
            if (rowZero[r]) {
                for (int i = 0; i < colZero.length; i++) {
                    matrix[r][i] = 0;
                }
            }
        }

        for (int c = 0; c < colZero.length; c++) {
            if (colZero[c]) {
                for (int i = 0; i < rowZero.length; i++) {
                    matrix[i][c] = 0;
                }
            }
        }

        printMatrix(matrix);
    }


    public static void printMatrix(int[] [] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col]);
                System.out.print(" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
}
