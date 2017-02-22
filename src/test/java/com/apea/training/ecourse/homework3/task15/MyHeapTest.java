package com.apea.training.ecourse.homework3.task15;

import org.junit.Assert;
import org.junit.Test;

import static com.apea.training.ecourse.homework3.task15.MyPriorityQueue.MyHeap;

public class MyHeapTest {

    private MyHeap<Integer> myHeap;

    public MyHeapTest() {
        myHeap = new MyHeap<>(Integer::compareTo);
        myHeap.array.add(35);
        myHeap.array.add(-45);
        myHeap.array.add(22);
        myHeap.array.add(-2);
        myHeap.array.add(40);
        myHeap.array.add(0);
        myHeap.buildMaxHeap();
    }

    @Test
    public void buildMaxHeapTest() {
        Assert.assertArrayEquals(myHeap.array.toArray(),
                new Object[]{40, 35, 22, -2, -45, 0});
    }

    @Test
    public void insertTest() {
        myHeap.insert(40);
        Assert.assertArrayEquals(myHeap.array.toArray(),
                new Object[]{40, 35, 40, -2, -45, 0, 22});
    }

    @Test
    public void maximumTest() {
        Assert.assertEquals(myHeap.maximum().intValue(), 40);
    }

    @Test
    public void extractMaximumTest() {
        myHeap.extractMaximum();
        Assert.assertArrayEquals(myHeap.array.toArray(),
                new Object[]{35, 0, 22, -2, -45});
    }
}
