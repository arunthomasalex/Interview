package com.tutorial.others;

import java.util.Random;

public class Base62 {
    public static void main(String[] args) {
        int n = new Random().ints(14776336, 916132832).findAny().orElse(-1);
        final char[] BASE62 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            sb.append(BASE62[n % 62]);
            n /= 62;
        }
        System.out.println(sb.reverse());
    }
}
