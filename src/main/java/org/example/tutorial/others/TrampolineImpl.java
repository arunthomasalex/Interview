package org.example.tutorial.others;

import java.util.stream.Stream;

interface Trampoline<T> {
    T get();

    default Trampoline<T> jump() {
        return this;
    }

    default T result() {
        return get();
    }

    default boolean complete() {
        return true;
    }

    static <T> Trampoline<T> done(final T result) {
        return () -> result;
    }

    static <T> Trampoline<T> more(final Trampoline<Trampoline<T>> trampoline) {
        return new Trampoline<T>() {
            @Override
            public boolean complete() {
                return false;
            }

            @Override
            public Trampoline<T> jump() {
                return trampoline.result();
            }

            @Override
            public T get() {
                return trampoline(this);
            }

            private T trampoline(final Trampoline<T> trampoline) {
                return Stream.iterate(trampoline, Trampoline::jump)
                        .filter(Trampoline::complete)
                        .findFirst()
                        .map(Trampoline::result)
                        .orElseThrow();
            }

        };

    }
}

public class TrampolineImpl {
    public static Trampoline<Integer> loop(int times, int prod) {
        return (times == 0) ? Trampoline.done(prod) : Trampoline.more(() -> loop(times - 1, prod * times));
    }

    public static void main(String[] args) {
        var result = loop(4, 1).result();
        System.out.println(result);
    }
}