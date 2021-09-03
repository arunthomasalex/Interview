package org.example.tutorial.hackerearth;

import java.util.*;
/**
 * CPP code for passing the test in hackerearth
#include <iostream>
using namespace std;
int main() {
	int itr;
	cin >> itr;
	for(; itr > 0; itr--) {
		int n, s, v;
		cin >> n >> s;
		int arr[n];
		int j = s % n;
		cout << j << endl;
		for(int i = 0; i < n; i++, j = (++j)%n ) {
		   	cin >> arr[j];
		}
		for(int i = 0; i < n; i++) {
		    cout << arr[i] << " ";
		}
		cout << endl;
	}
}
 */
class MonkAndRotation {
    public static void main(String[] args) {
        List<int[]> arrays = new ArrayList<>();
        try(Scanner s = new Scanner(System.in)) {
            int n = s.nextInt();
            for(; n > 0; n--) {
                int size = s.nextInt();
                int itr = s.nextInt();
                int[] arr = new int[size];
                for (int i = 0; i < size; i++) {
                    arr[(i + itr) % size] = s.nextInt();
                }
                arrays.add(arr);
            }
        }
        arrays.forEach(a -> {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        });
    }
}

