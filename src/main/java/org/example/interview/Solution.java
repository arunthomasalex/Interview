package org.example.interview;


public class Solution {  
    public static void main(String[] args) {
        char[] seq = "arun".toCharArray();
        for (int i = 0; i < seq.length - 1; i++) {
            seq[i] ^= seq[i + 1];
            seq[i + 1] ^= seq[i];
            seq[i] ^= seq[i + 1];
        }
        for(char c : seq) {
            System.out.println(c);
        }
    }
}
