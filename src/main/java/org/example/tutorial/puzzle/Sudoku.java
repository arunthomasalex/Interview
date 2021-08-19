package org.example.tutorial.puzzle;

public class Sudoku {
    private static final int N = 9;
    public static void main(String[] args) {
        int grid[][] = { { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                         { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                         { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                         { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                         { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                         { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                         { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                         { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                         { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
        if(solve(grid, 0 , 0)) {
            print(grid);
        } else {
            System.out.println("Unsolvable");
        }
    }

    private static void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean solve(int[][] grid, int row, int col) {
        if(row >= N-1 && col >= N) {
            return true;
        }
        if(col == N) {
            row++;
            col = 0;
        }
        if(grid[row][col] != 0) return solve(grid, row, col + 1);
        for (int i = 1; i <= N; i++) {
            if(isSafe(grid, row, col, i)) {
                grid[row][col] = i;
                if(solve(grid, row, col + 1)) return true;
            }
            grid[row][col] = 0;   
        }
        return false;
    }

    private static boolean isSafe(int[][] grid, int row, int col, int num) {
        for (int y = 0; y < N; y++) {
            if(grid[row][y] == num) return false;
        }
        for (int x = 0; x < N; x++) {
            if(grid[x][col] == num) return false;
        }
        int startRow = row - row % 3, startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(grid[i + startRow][j + startCol] == num) return false;
            }
        }
        return true;
    }
}
