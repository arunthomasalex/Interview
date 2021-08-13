package com.tutorial.strings;

import java.util.*;
import java.util.stream.Collectors;

public class Anagram {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("tea", "eat", "bat", "sit", "tab", "run", "ate", "ofo", "off");
        Map<String, List<String>> anagramMap = list.stream()
                                                    .collect(
                                                            Collectors.groupingBy(
                                                                    s -> s.chars()
                                                                            .sorted()
                                                                            .mapToObj(i -> Character.toString(i))
                                                                            .collect(Collectors.joining())
                                                            ));
        anagramMap.values().stream().sorted((l1 , l2) -> l1.size() > l2.size() ? 1 : -1).forEach(System.out::println);
    }
}
