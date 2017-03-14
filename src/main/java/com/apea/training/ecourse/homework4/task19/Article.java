package com.apea.training.ecourse.homework4.task19;

public class Article implements Cloneable {
    public String heading;
    public String content;
    public String id;

    Article(String heading, String content) {
        this.heading = heading;
        this.content = content;
    }

    Article(String id, String heading, String content) {
        this.heading = heading;
        this.content = content;
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    void setId(String id) {
        this.id = id;
    }

    @Override
    protected Object clone() {
        return new Article(heading, content);
    }
}
