package org.example.tutorial.others;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import static java.lang.Math.*;

public class CheckPowerOfTwo {
    public static void main(String[] args) {
        IntPredicate predicate = (n) -> {
            if(n == 0) return false;
            return ((int)ceil((log(n)/log(2)))) == ((int)floor((log(n)/log(2))));
        };
        IntStream.range(0, 10).filter(predicate).forEach(System.out::println);
        for (int i = 0; i < 10; i++) {
            if(predicate.test(i)) System.out.println(i);
        }
    }
}
