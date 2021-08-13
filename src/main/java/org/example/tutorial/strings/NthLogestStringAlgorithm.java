package org.example.tutorial.strings;

import java.util.*;
import java.util.stream.Collectors;

public class NthLogestStringAlgorithm {
    public static void main(String[] args) {
        List<String> list = List.of("Yuri", "Ron", "Interview", "Longest", "List", "Contain");
        Map<Integer, List<String>> m = list.stream()
                                                .collect(
                                                        Collectors.collectingAndThen( // downstream activates first then the finisher is call to create an unmodifiable map
                                                                Collectors.groupingBy(s->s.length(), Collectors.toList()),
                                                                Collections::<Integer, List<String>>unmodifiableMap
                                                        )
                                                );
        System.out.println(list.stream().max((v1, v2) -> v1.length() > v2.length() ? 1: -1).get());
    }
}
