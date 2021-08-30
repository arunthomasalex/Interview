package org.example.tutorial.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Votecalculation {
    public static void main(String[] args) {
        String[] votes = { "john", "johnny", "jackie",
                         "johnny", "john", "jackie",
                         "jamie", "jamie", "john",
                         "johnny", "jamie", "johnny",
                         "john" };
        Map<String, Long> votesCount = Stream.of(votes).collect(Collectors.groupingBy(Function.identity(), HashMap<String, Long>::new, Collectors.counting()));
        System.out.println(votesCount.entrySet().stream().max((e1, e2) -> e1.getValue() > e2.getValue() ? 1 : -1).get().getKey());
    }
}
