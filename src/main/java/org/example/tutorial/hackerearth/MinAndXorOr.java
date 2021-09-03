package org.example.tutorial.hackerearth;

import java.util.*;
import java.util.concurrent.*;

/**
 * CPP code for passing the test in hackerearth
#include <bits/stdc++.h>

using namespace std;

int main() {
	int itr;
	cin >> itr;
	for(; itr > 0; itr--) {
		int n, m = 2147483647, v;
		cin >> n;
		int arr[n];
		for(int i = 0; i < n; i++) {
		   	cin >> arr[i];
		}
		sort(arr, arr + n);
		int a, b;
		for(int i = 0; i < n-1; i++) {
			a = arr[i], b = arr[i + 1];
			v = ((a & b) ^ (a | b));
			if(v < m) m = v;
		}
		cout << m << endl;
	}
}
 */

public class MinAndXorOr {
    public static Integer get(Future<Integer> future) {
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e.getCause());
        }
    }
    public static Callable<Integer> createTask(final int[] arr, final int size) {
        return () -> {
            int m = Integer.MAX_VALUE;
            Arrays.sort(arr);
            for (int i = 0; i < size-1; i++) {
                int v = ((arr[i] & arr[i+1]) ^ (arr[i] | arr[i+1]));
                if(v < m) m = v;

            }
            return m;
        };
    }
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        List<Future<Integer>> values = new ArrayList<>();
        try(Scanner s = new Scanner(System.in)) {
            int itr = s.nextInt();
            for(; itr > 0; itr--) {
                int n = s.nextInt();
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = s.nextInt();
                }
                values.add(service.submit(createTask(arr, n)));
            }
        }
        service.shutdown();
        values.stream().map(MinAndXorOr::get).forEach(System.out::println);
    }
}
