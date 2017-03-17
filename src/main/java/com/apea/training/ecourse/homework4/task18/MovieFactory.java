package com.apea.training.ecourse.homework4.task18;

public class MovieFactory {

    private static MovieFactory instance = new MovieFactory();

    private MovieFactory() {}

    public static MovieFactory getInstance() {
        return instance;
    }

    public Movie createMovie(String name, Language language) {
        switch (language) {
            case RUSSIAN: return RussianFactory.getInstance().createMovie(name);
            case ENGLISH: return EnglishFactory.getInstance().createMovie(name);
            default: return null;
        }
    }
}
