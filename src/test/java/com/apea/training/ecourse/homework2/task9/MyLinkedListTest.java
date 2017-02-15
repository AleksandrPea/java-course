package com.apea.training.ecourse.homework2.task9;

import com.apea.training.ecourse.homework2.task8.MyListAbstractTest;

public class MyLinkedListTest extends MyListAbstractTest {

    @Override
    public void makeList() {
        list = new MyLinkedList<Integer>(){{
            add(25);
            add(null);
            add(-45);
            add(4);
        }};
    }
}
