package org.example.tutorial.others;

import static org.example.tutorial.others.Trampoline.more;
import static org.example.tutorial.others.Trampoline.done;

public class TrampolineFactorial {
    public static Trampoline<Integer> factorial(int times, int prod) {
        return (times == 0) ? done(prod) : more(() -> factorial(times - 1, prod * times));
    }

    public static void main(String[] args) {
        Trampoline<Integer> t = factorial(4, 1);
        var result = t.get();
        System.out.println(result);
    }
}