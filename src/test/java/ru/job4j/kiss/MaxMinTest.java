package ru.job4j.kiss;

import org.junit.BeforeClass;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class MaxMinTest {
    static MaxMin maxMin;
    static Comparator<Integer> comparator;
    static List<Integer> list;

    @BeforeClass
    public static void beforeClass() throws Exception {
        maxMin = new MaxMin();
        comparator = Integer::compare;
        list = List.of(5, 3, 7, 4, 1);
    }

    @org.junit.Test
    public void max() {
        assertEquals(7, (int) maxMin.max(list, comparator));
    }

    @org.junit.Test
    public void min() {
        assertEquals(1, (int) maxMin.min(list, comparator));
    }
}