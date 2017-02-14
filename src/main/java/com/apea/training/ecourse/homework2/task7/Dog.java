package com.apea.training.ecourse.homework2.task7;

public class Dog extends Animal {

    private String breed;

    protected Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    public static Dog bringToTheWorld(String name, String breed) {
        if (name == null || breed == null) {
            throw new NullPointerException("Please give not null name and breed of the dog");
        }
        return new Dog(name, breed);
    }

    @Override
    public void run() {
        System.out.println(getName()+" is running on all four paws.");
    }

    public void jump() {
        System.out.println(getName()+" is jumping.");
    }

    public void bark() {
        System.out.println(getName()+": Gav gav!");
    }

    public void bite(Dog other) {
        System.out.println(getName()+" bites "+other.getName());
        other.bark();
    }

    @Override
    public String toString() {
        return getName()+"[of "+breed+"]";
    }
}
