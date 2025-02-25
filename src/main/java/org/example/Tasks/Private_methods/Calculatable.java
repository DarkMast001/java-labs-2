package org.example.Tasks.Private_methods;

/**
 * В интерфейсах private методы обязаны иметь реализацию
 */

public interface Calculatable {
    default int sum(int a, int b) {
        return sumAll(a, b);
    }

    default int sum(int a, int b, int c) {
        return sumAll(a, b, c);
    }

    private int sumAll(int... values) {
        int result = 0;
        for (int n : values) {
            result += n;
        }
        return result;
    }
}
