package com.apea.training.ecourse.homework2.task8;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class MySingleLinkedListTest {

    private MySingleLinkedList<Integer> list;

    @Before
    public void makeList() {
        list = new MySingleLinkedList<Integer>(){{
            add(25);
            add(null);
            add(-45);
            add(4);
        }};
    }

    /** get(0), get(1), get(size-1) */
    @Test
    public void getTest() {
        Assert.assertEquals(list.get(0), new Integer(25));
        Assert.assertNull(list.get(1));
        Assert.assertEquals(list.get(list.size()-1), new Integer(4));
    }

    /** get(-1) */
    @Test(expected = IndexOutOfBoundsException.class)
    public void getNegIndexTest() {
        list.get(-1);
    }

    /** get(size) */
    @Test(expected = IndexOutOfBoundsException.class)
    public void getBigIndexTest() {
        list.get(list.size());
    }

    @Test
    public void toArrayTest() {
        Assert.assertArrayEquals(list.toArray(), new Object[]{25, null, -45, 4});
    }

    /** insert(size), insert(3), insert(0) */
    @Test
    public void insertTest() {
        list.insert(list.size(), 49);
        list.insert(3, 125);
        list.insert(0, 55);
        Assert.assertArrayEquals(list.toArray(), new Object[]{55, 25, null, -45, 125, 4, 49});
    }

    /** insert(size), insert(3), insert(0) */
    @Test
    public void insertNullTest() {
        list.insert(list.size(), null);
        list.insert(3, null);
        list.insert(0, null);
        Assert.assertArrayEquals(list.toArray(), new Object[]{null, 25, null, -45, null, 4, null});
    }
}
