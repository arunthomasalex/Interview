package org.example.tutorial.concepts;

import java.util.function.Supplier;

public class LazyEvaluation {
    static boolean compute(String str) {
        System.out.println("executing...");
        return str.contains("a");
    }

    /**
     * Supplier gets executed when the get method is called,
     * so when the first supplier outputs false the next supplier is not executed.
     **/
    static String lazyMatch(Supplier<Boolean> a, Supplier<Boolean> b) {
        return (a.get() && b.get()) ? "match" : "incompatible!";
    }
    
    public static void main(String[] args) {
        System.out.println(lazyMatch(() -> compute("bb"), () -> compute("aa")));
    }
}
