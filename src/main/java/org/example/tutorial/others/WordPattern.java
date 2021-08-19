package org.example.tutorial.others;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WordPattern {
    public static void main(String[] args) {
        String sentence = "We make a living by what we get";
        String[] words = sentence.split(" ");
        int iteration = Stream.of(words).sorted((s1, s2) -> (s1.length() < s2.length() ? 1 : -1)).findFirst().get().length();
        IntStream.range(0, iteration).forEach(i -> {
            for(String word : words) {
                System.out.print((word.length() > i ? word.substring(i, i+1) : " " ));
            }
            System.out.println();
        });
    }
}
