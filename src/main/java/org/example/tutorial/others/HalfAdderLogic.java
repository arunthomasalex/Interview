package org.example.tutorial.others;

public class HalfAdderLogic {
    public static void main(String[] args) {
        int a = 5, b = 4;
        System.out.println(String.format("%d + %d = " + add(a, b), a, b));
    }

    private static int add(int a, int b) {
//        System.out.println(String.format("a = %d(%s), b = %d(%s)", a, Integer.toBinaryString(a), b, Integer.toBinaryString(b)));
        if (b == 0) return a;
        return add((a ^ b), ((a & b) << 1));
    }
}
