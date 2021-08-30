package org.example.tutorial.others;

import java.util.stream.Stream;

interface Trampoline<T> {

    T get();

    default Trampoline<T> next() {
        return this;
    }

    default boolean complete() {
        return true;
    }

    static <T> Trampoline<T> done(T result) {
        return () -> result;
    }

    static <T> Trampoline<T> more(final Trampoline<Trampoline<T>> trampoline) {
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
            public T get() {
                return exec(this);
            }

            private T exec(final Trampoline<T> seed) {
                return Stream.iterate(seed, Trampoline::next)
                        .filter(Trampoline::complete).findAny()
                        .map(Trampoline::get).orElseThrow();
            }
        };
    }

}
