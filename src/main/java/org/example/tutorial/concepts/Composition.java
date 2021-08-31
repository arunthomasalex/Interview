package org.example.tutorial.concepts;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Composition {
    public static void main(String[] args) {
        //Predicate composition
        List<Integer> ages = Arrays.asList(5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80, 85, 90, 95);
        Predicate<Integer> adult = a -> a > 18;
        Predicate<Integer> notSenior = a -> a < 60;
        System.out.println("Predicate composition");
        ages.stream().filter(adult.and(notSenior)).forEach(System.out::println);
        System.out.println();

        //Function composition
        List<Integer> radious = Arrays.asList(3, 4, 5, 6);
        Function<Integer, Integer> square = r -> r * r;
        Function<Integer, Double> area = r -> 3.14 * r;
        System.out.println("Function composition");
        radious.stream().map(square.andThen(area)).forEach(System.out::println);
    }
}
