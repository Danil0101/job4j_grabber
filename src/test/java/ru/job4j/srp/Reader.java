package ru.job4j.srp;

public interface Reader<T> {
    T read();

    void write(T data);
}
