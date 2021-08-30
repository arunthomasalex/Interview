package org.example.tutorial.strings;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WordPattern {
    public static void main(String[] args) {
        String sentence = "We make a living by what we get.";
        String[] words = sentence.split(" ");
        int iteration = Stream.of(words).mapToInt(s -> s.length()).max().getAsInt();
        IntStream.range(0, iteration).forEach(i -> {
            for(String word : words) {
                System.out.print((word.length() > i ? word.substring(i, i+1) : " " ));
            }
            System.out.println();
        });
    }
}
