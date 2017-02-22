package com.apea.training.ecourse.homework3.task15;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyPriorityQueueTest {

    private MyPriorityQueue<Integer> queue;

    public MyPriorityQueueTest() {
        queue = MyPriorityQueue.newInstance(Integer::compareTo);
        queue.add(-3);
        queue.add(-45);
        queue.offer(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceptionNewInstanceTest() {
        MyPriorityQueue.newInstance(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void exceptionRemoveTest() {
        queue.clear();
        queue.remove();
    }

    @Test
    public void removeTest() {
        Assert.assertEquals(queue.remove().intValue(), 2);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeWithElementTest() {
        queue.remove(3);
    }

    @Test
    public void pollEmptyTest() {
        queue.clear();
        Assert.assertNull(queue.poll());
    }

    @Test
    public void pollTest() {
        Assert.assertEquals(queue.poll().intValue(), 2);
    }

    @Test(expected = NoSuchElementException.class)
    public void exceptionElementTest() {
        queue.clear();
        queue.element();
    }

    @Test
    public void elementTest() {
        Assert.assertEquals(queue.element().intValue(), 2);
        Assert.assertTrue(queue.contains(2));
    }

    @Test
    public void peekNullTest() {
        queue.clear();
        Assert.assertNull(queue.peek());
    }

    @Test
    public void peekTest() {
        Assert.assertEquals(queue.peek().intValue(), 2);
        Assert.assertTrue(queue.contains(2));
    }

    @Test
    public void clearTest() {
        queue.clear();
        Assert.assertEquals(queue.size(), 0);
    }

    @Test
    public void isEmptyTest() {
        queue.clear();
        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void containsTest() {
        Assert.assertFalse(queue.contains(100));
    }

    @Test
    public void containsAllTest() {
        Assert.assertTrue(queue.containsAll(Arrays.asList(-45, 2, -3)));
    }

    @Test
    public void addAllTest() {
        queue.addAll(Arrays.asList(34, -23, 67, 100));
        Assert.assertEquals(queue.peek().intValue(), 100);
    }

    @Test
    public void retainAllTest() {
        queue.retainAll(Arrays.asList(-45, -3));
        Assert.assertFalse(queue.contains(2));
    }

    @Test
    public void toArrayTest() {
        queue.removeAll(Arrays.asList(queue.toArray()));
        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void toArrayWithParamTest() {
        Integer[] arr = new Integer[3];
        queue.removeAll(Arrays.asList(queue.toArray(arr)));
        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void iteratorTest() {
        Integer[] arr = new Integer[3];
        int i = 0;
        for (Integer elem : queue) {
            arr[i++] = elem;
        }
        queue.removeAll(Arrays.asList(arr));
        Assert.assertTrue(queue.isEmpty());
    }

}
