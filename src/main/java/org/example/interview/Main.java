package org.example.interview;

import java.util.Arrays;

import org.example.tutorial.sorting.Sort;
import org.example.tutorial.sorting.SortEnum;

public class Main {
    static int fact(int n, int reduce) {
        return (n <= 1) ? reduce : fact(n - 1, n * reduce);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(fact(5, 1));
        Sort sort = Sort.getInstance(SortEnum.QUICK_SORT, Arrays.asList(3, 5, 4, 6, 2, 2, 1));
        sort.sort();
        System.out.println(sort.result().stream().collect(StringBuilder::new, (sb, s1) -> sb.append(s1).append(" "),
                StringBuilder::append));
    }
}
