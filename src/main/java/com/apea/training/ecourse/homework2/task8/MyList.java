package com.apea.training.ecourse.homework2.task8;

public interface MyList<E> {

    E get(int index);

    void add(E elem);

    void insert(int index, E elem);

    E remove(int index);

    boolean remove(E elem);

    boolean contains(E elem);

    Object[] toArray();

    int size();

}
