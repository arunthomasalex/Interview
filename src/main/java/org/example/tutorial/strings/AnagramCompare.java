package org.example.tutorial.strings;

import java.util.Arrays;

public class AnagramCompare {
    public static void main(String[] args) {
        String a = "arun";
        String b = "runa";
        char[] aarray = a.toCharArray();
        Arrays.sort(aarray);
        char[] barray = b.toCharArray();
        Arrays.sort(barray);
        String.valueOf(aarray).equals(String.valueOf(barray));
        System.out.println("Anagram: " + String.valueOf(aarray).equals(String.valueOf(barray)));
    }
}
