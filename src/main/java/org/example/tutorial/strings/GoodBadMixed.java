package org.example.tutorial.strings;

import java.util.Arrays;
/*
    ??aa?? - MIXED
    abc - GOOD
    aaa?aaafff - BAD
    aaaa?ff?aaa?aaa?fff - BAD
    aaaaff? - MIXED
    aaaaf? - GOOD
    ?aaaaffaaf?aaaafff - BAD
    ?aaaaffaaf?aaaaff - MIXED
    vaxaaaa?bbadadada - BAD
    aaaa?bb - BAD
    vabb?aaaadadada - BAD
    vabab?aaaadadada - MIXED
*/
public class GoodBadMixed {
    public static void main(String[] args) {
        String data = "vabab?aaaadadada";
        int[] vowel, consonent;
        vowel = findVowels(data);
        consonent = findConsonent(data);
        for(int i = 1; i < vowel.length; i++) {
            if(vowel[i] != 0) vowel[i] += vowel[i-1];
        }
        for(int i = 1; i < consonent.length; i++) {
            if(consonent[i] != 0) consonent[i] += consonent[i-1];
        }
        printArray(vowel);
        printArray(consonent);
        boolean validVowel = (Arrays.stream(vowel).max().getAsInt() < 5), 
                validConsonent = (Arrays.stream(consonent).max().getAsInt() < 3);
        if(validVowel && validConsonent) {
            System.out.println("GOOD");
        } else if(validVowel || validConsonent) {
            System.out.println("MIXED");
        } else {
            System.out.println("BAD");
        }
    }



    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }



    private static int[] findConsonent(String data) {
        return data.chars().map(c -> {
            if((c != 97 && c != 101 && c != 105 && c != 111 && c != 117) || c == 63) {
                return 1;
            }
            return 0;
        }).toArray();
    }

    private static int[] findVowels(String data) {
        return data.chars().map(c -> {
            if(c == 97 || c == 101 || c == 105 || c == 111 || c == 117 || c == 63) {
                return 1;
            }
            return 0;
        }).toArray();
    }
}
