package com.apea.training.ecourse.homework4.task19;

public class Article implements Cloneable {
    public String heading;
    public String content;
    public Long id;

    Article(Long id, String heading, String content) {
        this.heading = heading;
        this.content = content;
        this.id = id;
    }

    Article(String heading, String content) {
        this.heading = heading;
        this.content = content;
    }

    public String getHeading() {
        return heading;
    }

    public String getContent() {
        return content;
    }

    public Long getId() {
        return id;
    }

    void setHeading(String heading) {
        this.heading = heading;
    }

    void setContent(String content) {
        this.content = content;
    }

    void setId(Long id) {
        this.id = id;
    }

    @Override
    protected Object clone() {
        return new Article(heading, content);
    }
}
