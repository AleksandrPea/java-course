package com.apea.training.ecourse.homework4.task18;

public class EnglishFactory implements AbstractFactory {

    private static EnglishFactory instance = new EnglishFactory();

    private EnglishFactory() {}

    public static EnglishFactory getInstance() {
        return instance;
    }

    @Override
    public Movie createMovie(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Null name");
        }
        return new Movie(name, new EnglishSound(), new EnglishSubtitles());
    }
}
