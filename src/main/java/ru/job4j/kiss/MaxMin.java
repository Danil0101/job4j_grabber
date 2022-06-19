package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        if (value == null || comparator == null || value.isEmpty()) {
            throw new IllegalArgumentException();
        }
        T result = value.get(0);
        for (int i = 1; i < value.size(); i++) {
            result = comparator.compare(result, value.get(i)) > 0 ? result : value.get(i);
        }
        return result;
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return max(value, comparator.reversed());
    }
}
