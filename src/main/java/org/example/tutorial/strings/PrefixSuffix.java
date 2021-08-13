package org.example.tutorial.strings;

public class PrefixSuffix {
//    private static int longestPrefixSuffix(String s) {
//        int n = s.length();
//        int lps[] = new int[n];
//        lps[0] = 0;
//        int len = 0;
//        int i = 1;
//        while (i < n) {
//            if (s.charAt(i) == s.charAt(len)) {
//                len++;
//                lps[i] = len;
//                i++;
//            }
//            else {
//                if (len != 0) {
//                    len = lps[len-1];
//                }
//                else {
//                    lps[i] = 0;
//                    i++;
//                }
//            }
//        }
//        for (i = 0; i < lps.length; i++) {
//            System.out.print(lps[i] + " ");
//        }
//        System.out.println();
//        int res = lps[n-1];
//        return (res > n/2)? n/2 : res;
//    }
static int longestPrefixSuffix(String s) {
    int n = s.length();
    if(n < 2) {
        return 0;
    }
    int i = 0, j = (n + 1)/2;
    while(j < n) {
        if(s.charAt(i) == s.charAt(j)) {
            ++i; ++j;
        }
        else {
            j = j - i + 1;
            i = 0;
        }
    }
    return i;

}
    public static void main(String[] args) {
        String s = "adbadb";
        System.out.println(longestPrefixSuffix(s));
    }
}
