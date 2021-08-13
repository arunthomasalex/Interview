package org.example.tutorial.strings;

import java.util.HashSet;
import java.util.Set;

public class PalindromeSubStrings{
    static Set<String> strings = new HashSet<>();
    public static void findPalindromesInSubString(String input, int i, int j) {
        for (; i >= 0 && j < input.length(); --i, ++j) {
            if (input.charAt(i) != input.charAt(j)) break;
            strings.add(input.substring(i, (j + 1)));
        }
    }

    public static void findAllPalindromeSubstrings(String input) {
        for(int i = 0 ; i < input.length() ; ++i) {
            findPalindromesInSubString(input, i-1, i+1);
            findPalindromesInSubString(input, i, i+1);
        }
    }

    public static void main(String[] args) {
        String str = "ababa";
        findAllPalindromeSubstrings(str);
        System.out.println("Total palindrome substrings: " + strings.size());
        System.out.println(strings);
        System.out.println(strings.stream().sorted((o1, o2) -> o1.length() < o2.length() ? 1 : -1).findFirst().get());
    }
}
