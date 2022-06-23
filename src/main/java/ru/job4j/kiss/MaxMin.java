package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        BiPredicate<T, T> predicate = (t1, t2) -> comparator.compare(t1, t2) < 0;
        return findMaxOrMin(value, predicate);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        BiPredicate<T, T> predicate = (t1, t2) -> comparator.compare(t1, t2) > 0;
        return findMaxOrMin(value, predicate);
    }

    public <T> T findMaxOrMin(List<T> value, BiPredicate<T, T> predicate) {
        T result = value.get(0);
        for (int i = 1; i < value.size(); i++) {
            if (predicate.test(result, value.get(i))) {
                result = value.get(i);
            }
        }
        return result;
    }
}
