package org.example.tutorial.concepts;

import java.util.function.Supplier;
import java.util.stream.Stream;

public interface Trampoline<T> {

    T tramp();

    default Trampoline<T> next() {
        return null;
    }

    default boolean complete() {
        return true;
    }

    static <T> Trampoline<T> done(T result) {
        return () -> result;
    }

    static <T> Trampoline<T> more(final Supplier<Trampoline<T>> trampoline) {
        return new Trampoline<T>() {
            @Override
            public boolean complete() {
                return false;
            }

            @Override
            public Trampoline<T> next() {
                return trampoline.get();
            }

            @Override
            public T tramp() {
                return execute(this);
            }

            private T execute(final Trampoline<T> seed) {
                return Stream.iterate(seed, Trampoline::next)
                        .filter(Trampoline::complete).findAny()
                        .map(Trampoline::tramp).orElseThrow();
            }
        };
    }

}
