package ru.job4j.lsp;

public class Cat extends Animal {

    public Cat(boolean isFlying, int age) {
        super(isFlying, age);
    }

    @Override
    public void move() {
        fly();
    }

    @Override
    public void say() {
        if (age < 1) {
            System.out.println("pee pee");
        } else {
            super.say();
        }
    }

    @Override
    public String hunt() {
        return "Hunt is start";
    }
}
