package org.example.tutorial.hackerearth;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.concurrent.*;

public class DivideDigits {
    public static void main(String[] args) throws IOException {
        ExecutorService service = Executors.newWorkStealingPool(2);
        List<Future<Integer>> lst = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            for (; n > 0; n--) {
                lst.add(service.submit(createTask(reader.readLine())));
            }
            String result =  lst.stream().map(DivideDigits::get).map(x -> x.toString()).collect(Collectors.joining("\n"));
            System.out.println(result);
        } finally {
            service.shutdown();
        }
    }

    static class Points {
        private Integer x, y;
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
            if (obj == null || getClass() != obj.getClass())
                return false;
            Points other = (Points) obj;
            if (x == null && (other.x != null || !x.equals(other.x)))
                return false;
            if (y == null && (other.y != null || !y.equals(other.y)))
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
                                                Collectors.collectingAndThen(Collectors.toList(),
                                                    x -> x.stream().sorted().collect(Collectors.joining())
                                                )
                                            )
                                        ));
            xy.add(new Points(temp.get(true), temp.get(false)));
        } else {
            for (int i = 0; i < n; i++) {
                findAllPermutations(n - 1, elements, xy, mid);
                swap(elements, i, n - 1);
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
