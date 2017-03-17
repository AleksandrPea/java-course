package com.apea.training.ecourse.homework4.task22;

public class Subscriber {

    private Publisher publisher;
    private Magazine myMagazine;

    private Subscriber(Publisher publisher){
        this.publisher = publisher;
    }

    public static Subscriber createSubscriber(Publisher publisher) {
        if (publisher == null) {
            throw new IllegalArgumentException("Null publisher");
        }
        return new Subscriber(publisher);
    }

    public void update() {
        myMagazine = publisher.getPostDepartment().getFrom(publisher);
    }

    public Magazine getMyMagazine() {
        return myMagazine;
    }
}
