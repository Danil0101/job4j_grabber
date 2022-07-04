package ru.job4j.lsp;

public class Animal {
    protected boolean isFlying;
    protected boolean isTired;
    protected int age;

    public Animal(boolean isFlying, int age) {
        this.isFlying = isFlying;
        this.age = age;
    }

    public void move() {
        if (isFlying) {
            fly();
        } else {
            walk();
        }
    }

    public void say() {
        System.out.println("RRR");
    }

    public String hunt() {
        if (isTired) {
            sleep();
            return "...";
        } else {
            return "Hunt is start";
        }
    }

    protected void sleep() {

    }

    protected void fly() {

    }

    protected void walk() {

    }
}
