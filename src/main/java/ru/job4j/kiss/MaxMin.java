package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return findMaxOrMin(value, comparator, true);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return findMaxOrMin(value, comparator, false);
    }

    public <T> T findMaxOrMin(List<T> value, Comparator<T> comparator, boolean isMax) {
        if (value == null || comparator == null || value.isEmpty()) {
            throw new IllegalArgumentException();
        }
        T result = value.get(0);
        for (int i = 1; i < value.size(); i++) {
            int compare = comparator.compare(result, value.get(i));
            if (isMax) {
                result = compare > 0 ? result : value.get(i);
            } else {
                result = compare < 0 ? result : value.get(i);
            }
        }
        return result;
    }
}
