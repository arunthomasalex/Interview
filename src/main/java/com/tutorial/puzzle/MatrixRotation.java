package com.tutorial.puzzle;

public class MatrixRotation {
    public static void main(String[] args) throws InterruptedException {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        while (true) {
            int[][] tempMatrix = new int[matrix[0].length][matrix.length];
            for (int i = 0, k = matrix[0].length - 1; i < matrix.length; i++, k--) {
                for (int j = 0; j < matrix[i].length; j++) {
                    tempMatrix[j][k] = matrix[i][j];
                }
            }
            matrix = tempMatrix;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + ", ");
                }
                System.out.println();
            }
            System.out.println();
            Thread.sleep(5000);
        }
    }
}