package org.example.tutorial.others;

import java.util.*;

public class SubArrayElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>(deque);
            
        int n = in.nextInt();
        int m = in.nextInt();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int input = in.nextInt();
            
            deque.add(input);
            set.add(input);

            if (deque.size() == m) {
                if (set.size() > max) max = set.size();
                int first = deque.removeFirst();
                if(!deque.contains(first)) set.remove(first);
            }
        }
        
        System.out.println(max);
    }
}
