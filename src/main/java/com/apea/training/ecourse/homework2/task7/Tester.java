package com.apea.training.ecourse.homework2.task7;

public class Tester {

    public static void main(String[] args) {
        Dog barbos = new Dog("Barbos", "sheep dog");
        Puppy bim = new Puppy("Bim", "Black ear");

        Animal aBim = bim;
        aBim.run();

        barbos.jump();
        barbos.bark();
        barbos.bite(bim);
    }
}
