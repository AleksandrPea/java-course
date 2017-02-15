package com.apea.training.ecourse.homework2.task8;

public class MySingleLinkedListTest extends MyListAbstractTest {

    @Override
    public void makeList() {
        list = new MySingleLinkedList<Integer>(){{
            add(25);
            add(null);
            add(-45);
            add(4);
        }};
    }
}
