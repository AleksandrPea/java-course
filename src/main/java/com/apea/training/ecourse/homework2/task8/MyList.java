package com.apea.training.ecourse.homework2.task8;

public interface MyList<E> extends Iterable<E> {

    E get(int index);

    default void add(E elem) {
        insert(size(), elem);
    }

    void insert(int index, E elem);

    E remove(int index);

    default void clear() {
        int oldSize = size();
        for (int i = 0; i < oldSize; i++) {
            remove(0);
        }
    }

    boolean remove(E elem);

    boolean contains(E elem);

    Object[] toArray();

    int size();

}
