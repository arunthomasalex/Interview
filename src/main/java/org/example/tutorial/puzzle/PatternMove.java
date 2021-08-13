package org.example.tutorial.puzzle;

public class PatternMove {
    public static void main(String[] args) throws InterruptedException {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        while (true) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++)
                    System.out.print(array[i][j] + " ");
            }
            System.out.print("\r");
            int temp = 0, i = 0, j = 0, k = 0, l = 0;
            while (true) {
                if (i == k && j == l) {
                    temp = array[i][j];
                    j++;
                } else {
                    array[k][l] = array[i][j];
                    k = i; l = j;
                    if (i >= (array.length - 1) && j >= (array[i].length - 1)) {
                        array[i][j] = temp;
                        break;
                    } else {
                        if (j >= (array[i].length - 1)) {
                            i++; j = 0;
                            continue;
                        }
                        j++;
                    }
                }
            }
            Thread.sleep(2000);
        }
    }
}
