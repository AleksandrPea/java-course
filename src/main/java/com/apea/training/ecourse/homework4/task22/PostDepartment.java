package com.apea.training.ecourse.homework4.task22;

import java.util.Map;
import java.util.HashMap;

public class PostDepartment {

    private Map<Publisher, Magazine> freshMagazines = new HashMap<>();

    public void recieve(Publisher publisher, Magazine magazine) {
        if (publisher == null || magazine == null) {
            throw new IllegalArgumentException("null argument");
        }
        freshMagazines.put(publisher, magazine);
        publisher.notifySubscribers();
    }

    public Magazine getFrom(Publisher publisher) {
        if (publisher == null) {
            throw new IllegalArgumentException("null publisher");
        }
        return freshMagazines.get(publisher);
    }
}
