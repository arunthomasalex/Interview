package org.example.tutorial.others;

import static org.example.tutorial.concepts.Trampoline.done;
import static org.example.tutorial.concepts.Trampoline.more;

import org.example.tutorial.concepts.Trampoline;

public class TrampolineFactorial {
    public static Trampoline<Integer> factorial(int times, int prod) {
        return (times == 0) ? done(prod) : more(() -> factorial(times - 1, prod * times));
    }

    public static void main(String[] args) {
        var result = factorial(5, 1).tramp();
        System.out.println(result);
    }
}