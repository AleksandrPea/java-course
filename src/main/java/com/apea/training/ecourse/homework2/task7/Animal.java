package com.apea.training.ecourse.homework2.task7;

public abstract class Animal {

    private String name;

    protected Animal(String name) {
        this.name = name;
    }

    public abstract void run();

    public String getName() {
        return name;
    }

    public void printName() {
        System.out.print(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
