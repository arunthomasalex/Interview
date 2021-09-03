package org.example.tutorial.hackerearth;

import java.util.*;
import java.util.concurrent.*;

public class MonkAndInversions {
    public static Integer get(Future<Integer> future) {
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    static int checkRight(int[][] arr, int ci, int cj, int i, int j, int count) {
        if (i >= arr.length || j >= arr.length)
            return count;
        if (arr[ci][cj] > arr[i][j]) {
            ++count;
        }
        return checkRight(arr, ci, cj, i + 1, j, count);
    }

    static int checkDown(int[][] arr, int ci, int cj, int i, int j, int count) {
        if (i >= arr.length || j >= arr.length)
            return count;
        if (arr[ci][cj] > arr[i][j]) {
            ++count;
        }
        return checkDown(arr, ci, cj, i, j + 1, count);
    }

    static int checkInner(int[][] arr, int ci, int cj, int count) {
        for (int i = ci + 1; i < arr.length; i++) {
            for (int j = cj + 1; j < arr.length; j++) {
                if (arr[ci][cj] > arr[i][j])
                    ++count;
            }
        }
        return count;
    }

    public static Callable<Integer> createTask(final int[][] arr) {
        return () -> {
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                    count = checkRight(arr, i, j, i + 1, j, count);
                    count = checkDown(arr, i, j, i, j + 1, count);
                    count = checkInner(arr, i, j, count);
                }
            }
            return count;
        };
    }

    public static void main(String args[]) throws Exception {
        ExecutorService service = Executors.newWorkStealingPool(2);
        List<Future<Integer>> counts = new ArrayList<>();
        try (Scanner s = new Scanner(System.in)) {
            int n = s.nextInt();
            for (; n > 0; n--) {
                int dimenison = s.nextInt();
                int[][] array = new int[dimenison][dimenison];
                for (int i = 0; i < array.length; i++) {
                    for (int j = 0; j < array.length; j++) {
                        array[i][j] = s.nextInt();
                    }
                }
                counts.add(service.submit(createTask(array)));
            }
        }
        counts.stream().map(MonkAndInversions::get).forEach(System.out::println);
        service.shutdown();
    }
}
