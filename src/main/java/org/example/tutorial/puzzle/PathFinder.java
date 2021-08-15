package org.example.tutorial.puzzle;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
Input
-----
3
6 2
0 1 0 1 0 1
10 6
0 0 1 1 0 0 1 1 0 0
10 3
0
0 1 1 0 0 1 1 0 0

Output
------
YES
NO
YES
*/
public class PathFinder {
    public static boolean traverse(Integer index, int leap, int[] game, Set<Integer> visited) {
        if (index < 0 || visited.contains(index)) {
            return false;
        }
        if (index >= game.length) {
            return true;
        } else if (game[index] == 1) {
            return false;
        }
        visited.add(index);
        return traverse(index - 1 , leap, game, visited) || traverse(index + 1, leap, game, visited)
                || traverse(index + leap, leap, game, visited);
    }

    public static boolean canWin(int leap, int[] game) {
        return traverse(0, leap, game, new HashSet<>());
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}
