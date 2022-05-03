package ru.job4j.gc;

public class User {
    private static int usersCount = 0;
    private static boolean finalizeHasBeenCalled = false;
    private final int age;

    public User(int age) {
        this.age = age;
    }

    @Override
    protected void finalize() throws Throwable {
        if (!finalizeHasBeenCalled) {
            System.out.printf("Создано объектов User: %d до первого вызова finalize%n", usersCount);
            finalizeHasBeenCalled = true;
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 100000; i++) {
            new User(i);
            usersCount++;
        }
    }
}
