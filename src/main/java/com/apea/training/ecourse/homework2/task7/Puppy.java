package com.apea.training.ecourse.homework2.task7;

public class Puppy extends Dog {

    public Puppy(String name, String breed) {
        super(name, breed);
    }

    public static Puppy bringToTheWorld(String name, String breed) {
        if (name == null || breed == null) {
            throw new IllegalArgumentException("Please give not null name and breed of the dog");
        }
        return new Puppy(name, breed);
    }

    @Override
    public void bark() {
        System.out.println("Doggy "+getName()+" barks squeakly.");
    }
}
