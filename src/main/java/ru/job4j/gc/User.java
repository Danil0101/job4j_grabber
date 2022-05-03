package ru.job4j.gc;

public class User {
    private static final long KB = 1000;
    private static final long MB = KB * KB;
    private static double byteCount = 0;
    private static boolean finalizeHasBeenCalled = false;
    private final int age;

    public User(int age) {
        this.age = age;
    }

    @Override
    protected void finalize() throws Throwable {
        if (!finalizeHasBeenCalled) {
            System.out.printf("Выделено памяти на объекты User: %.2f до первого вызова finalize%n", byteCount / MB);
            finalizeHasBeenCalled = true;
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 100000; i++) {
            new User(i);
            byteCount += 16 + 4;
        }
    }
}
