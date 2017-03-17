package com.apea.training.ecourse.homework4.task18;

public class RussianFactory implements AbstractFactory {

    private static RussianFactory instance = new RussianFactory();

    private RussianFactory() {}

    public static RussianFactory getInstance() {
        return instance;
    }

    @Override
    public Movie createMovie(String name) {
        if (name == null) {
            throw new IllegalArgumentException("null name");
        }
        return new Movie(name, new RussianSound(), new RussianSubtitles());
    }
}
