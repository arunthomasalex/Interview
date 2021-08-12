package com.tutorial.strings;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NonRepeatingChar {
    public static void main(String[] args) {
        String str = "aaooff";
        Map<String, Long> counter = str.chars()
                                            .mapToObj(i -> String.valueOf((char)i))
                                            .collect(
                                                    Collectors.groupingBy(
                                                            Function.identity(),
                                                            LinkedHashMap::new,
                                                            Collectors.counting()
                                                    )
                                            );
        Optional<Map.Entry<String, Long>> entry =  counter.entrySet().stream().filter(e -> e.getValue() == 1).findFirst();
        if(entry.isPresent()) {
            System.out.println(entry.get().getKey());
        } else {
            System.out.println("Not Present");
        }
    }
}
