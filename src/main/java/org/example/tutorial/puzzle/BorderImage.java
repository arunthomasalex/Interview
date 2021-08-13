package com.tutorial.puzzle;

import java.util.HashMap;
import java.util.Map;

public class BorderImage {
    static class Paths {
        private Map<String, Object> exist = new HashMap<>();
        void add(int i, int j) {
            this.exist.put(i + "-" + j, new Object());
        }
        boolean check(int i, int j) {
            return this.exist.get(i + "-" + j) != null;
        }
    }
    public static int[][] matrix = {
            {1, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 1},
            {0, 0, 0, 0, 0, 0},
            {1, 0, 1, 1, 1, 0},
            {1, 0, 1, 1, 0, 0},
            {1, 0, 0, 0, 0, 1}
    };
    public static boolean checkAdjacent(int i, int j, Paths paths) {
        if(paths.check(i,j)) return false;
        paths.add(i, j);
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix.length)
            return false;
        if (i == 0 || j == 0 || i == matrix.length - 1 || j == matrix[i].length - 1)
            return matrix[i][j] == 1;
        if (matrix[i][j] == 1)
            return checkAdjacent(i - 1, j, paths)
                    || checkAdjacent(i + 1, j, paths)
                    || checkAdjacent(i, j - 1, paths)
                    || checkAdjacent(i, j + 1, paths);
        return false;
    }
    public static void main(String[] args) {
        for (int i = 1; i < (matrix.length - 1); i++) {
            for (int j = 1; j < (matrix[i].length - 1); j++) {
                if(!checkAdjacent(i, j, new Paths())) {
                    matrix[i][j] = 0;
                }
            }
        }
        //Print the matrix after processing
        for (int i = 0; i < (matrix.length); i++) {
            for (int j = 0; j < (matrix[i].length); j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
