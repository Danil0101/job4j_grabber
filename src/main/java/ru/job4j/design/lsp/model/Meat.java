package ru.job4j.design.lsp.model;

import java.time.LocalDate;

public class Meat extends Food {
    public Meat(String name, LocalDate createDate, LocalDate expiryDate, double price, int discount) {
        super(name, createDate, expiryDate, price, discount);
    }
}
