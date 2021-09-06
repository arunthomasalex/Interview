package org.example.tutorial.hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class DivideDigits {
    public static void main(String[] args) throws IOException {
        ExecutorService service = Executors.newWorkStealingPool(2);
        List<Future<Integer>> lst = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            for (; n > 0; n--) {
                lst.add(service.submit(createTask(reader.readLine())));
            }
            StringBuilder builder = new StringBuilder();
            lst.stream().map(DivideDigits::get).forEach(v -> {
                builder.append(v).append("\n");
            });
            System.out.println(builder.toString());
        } finally {
            service.shutdown();
        }
    }

    static class Points {
        private Integer x;
        private Integer y;

        Points(String x, String y) {
            this.x = Integer.parseInt(x);
            this.y = Integer.parseInt(y);
        }

        public Integer sum() {
            return this.x + this.y;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((x == null) ? 0 : x.hashCode());
            result = prime * result + ((y == null) ? 0 : y.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Points other = (Points) obj;
            if (x == null) {
                if (other.x != null)
                    return false;
            } else if (!x.equals(other.x))
                return false;
            if (y == null) {
                if (other.y != null)
                    return false;
            } else if (!y.equals(other.y))
                return false;
            return true;
        }
    }

    public static Integer get(Future<Integer> future) {
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    private static Callable<Integer> createTask(String value) {
        return () -> {
            int mid = value.length() / 2;
            Set<Points> xy = new HashSet<>();
            findAllPermutations(value.length(), value.toCharArray(), xy, mid);
            return xy.stream().mapToInt(Points::sum).sorted().findFirst().getAsInt();
        };
    }

    private static void findAllPermutations(int n, char[] elements, Set<Points> xy, int mid) {
        if (n == 1) {
            Map<Boolean, String> temp = Stream
                                            .iterate(0, i -> i + 1)
                                            .limit(elements.length)
                                            .collect(Collectors.partitioningBy(i -> i < mid, 
                                                Collectors.mapping(i -> String.valueOf(elements[i]),
                                                    Collectors.collectingAndThen(Collectors.joining(),
                                                        x -> x.chars().sorted().mapToObj(v -> String.valueOf((char)v)).collect(Collectors.joining())
                                                    )
                                                )
                                            ));
            xy.add(new Points(temp.get(true), temp.get(false)));
        } else {
            for (int i = 0; i < n; i++) {
                findAllPermutations(n - 1, elements, xy, mid);
                if ((n & 1) == 0) {
                    swap(elements, i, n - 1);
                } else {
                    swap(elements, 0, n - 1);
                }
            }
        }
    }

    private static <T> void swap(char[] input, int a, int b) {
        if (a == b) return;
        input[a] ^= input[b];
        input[b] ^= input[a];
        input[a] ^= input[b];
    }
}
