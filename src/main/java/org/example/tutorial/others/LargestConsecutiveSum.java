package org.example.tutorial.others;

import java.util.ArrayList;
import java.util.List;

class Entry {
    public int start = 0, to = 0, value = 0;

    @Override
    public String toString() {
        return "Entry [start=" + start + ", to=" + to + ", value=" + value + "]";
    }
}

public class LargestConsecutiveSum {
    private static Entry maxSum(int[] array, int i) {
        Entry e = new Entry();
        e.start = i;
        int sum = 0;
        for (; i < array.length; i++) {
            sum += array[i];
            if (e.value < sum) {
                e.value = sum;
                e.to = i;
            }
        }
        return e;
    }

    public static void main(String[] args) {
        List<Entry> l = new ArrayList<>();
        int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
        for (int i = 0; i < a.length; i++) {
            l.add(maxSum(a, i));
        }
        Entry largest = l.stream().sorted((e1, e2) -> e1.value < e2.value ? 1 : -1).findFirst().get();
        System.out.println("Sum = " + largest.value + " started at " + largest.start + ".."  + largest.to);
    }
}
