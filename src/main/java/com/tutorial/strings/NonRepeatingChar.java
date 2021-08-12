package com.tutorial.strings;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NonRepeatingChar {
    public static void main(String[] args) {
        String str = "faoo";
        Map<String, Long> counter = str.chars()
                                            .mapToObj(i -> String.valueOf((char)i))
                                            .collect(
                                                    Collectors.groupingBy(
                                                            Function.identity(),
                                                            LinkedHashMap::new,
                                                            Collectors.counting()
                                                    )
                                            );
        counter.entrySet().stream().forEach(System.out::println);
    }
}
