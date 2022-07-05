package ru.job4j.design.ocp;

import java.util.List;

public class Store {
    List<Product> products;

    public Product buy(Buyer buyer) {
        int magicNumber = 7;
        return products.get(magicNumber);
    }

    private static class Buyer {

    }

    private static class Product {

    }
}

