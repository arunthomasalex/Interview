package org.example.tutorial.strings;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SubSets {
    public static void main(String[] args) {
        char[] values = {'a', 'b', 'c'};
        IntStream.range(1, (1 << values.length)).forEach(i -> { //0 to 2 ^ (length of array)
            System.out.println("{ " +
                    IntStream.range(0, values.length) // 0 to length of array
                            .filter(j -> (i & (1 << j)) > 0) // it is used to check which all bits are enables
                            .map(j -> values[j])
                            .mapToObj(v -> String.valueOf((char)v))
                            .collect(Collectors.joining(", ")) + " }"
            );
        });
    }
}
