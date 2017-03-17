package com.apea.training.ecourse.homework4.task18;

public class Movie {

    private String name;
    private Sound sound;
    private Subtitles subtitles;

    Movie(String name, Sound sound, Subtitles subtitles) {
        this.name = name;
        this.sound = sound;
        this.subtitles = subtitles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sound getSound() {
        return sound;
    }

    public Subtitles getSubtitles() {
        return subtitles;
    }
}
