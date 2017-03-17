package com.apea.training.ecourse.homework4.task22;

import java.util.ArrayList;
import java.util.List;

public class Publisher {

    private String logo;
    private PostDepartment postDepartment;
    private List<Subscriber> subscribers = new ArrayList<>();

    private Publisher(String logo, PostDepartment postDepartment) {
        this.logo = logo;
        this.postDepartment = postDepartment;
    }

    public static Publisher createPublisher(String logo, PostDepartment postDepartment) {
        if (logo == null || postDepartment == null) {
            throw new IllegalArgumentException("Null argument");
        }
        return new Publisher(logo, postDepartment);
    }

    public Magazine makeNewMagazine() {
        return new Magazine(logo+"-magazineV");
    }

    public void sendFreshMagazine() {
        postDepartment.recieve(this, makeNewMagazine());
    }

    public void register(Subscriber subscriber) {
        if (subscriber == null) {
            throw new IllegalArgumentException("Null subscriber");
        }
        subscribers.add(subscriber);
    }

    public void unregister(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update();
        }
    }

    public void setPostDepartment(PostDepartment postDepartment) {
        if (postDepartment == null) {
            throw new IllegalArgumentException("Null post department");
        }
        this.postDepartment = postDepartment;
    }

    public PostDepartment getPostDepartment() {
        return postDepartment;
    }

    public String getLogo() {
        return logo;
    }
}
