package org.example.tutorial.concepts;

import java.util.function.Function;

public class Currying {
    public static void main(String[] args) {
        Function<Integer, Function<Integer, Integer>> adder = a -> b -> a + b;
        System.out.println("Curry value = " + adder.apply(5).apply(2));
    }
}
