package com.apea.training.ecourse.homework2.task8;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public abstract class MyListAbstractTest {

    protected MyList<Integer> list;

    @Before
    public abstract void makeList();

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

    @Test
    public void sizeTest() {
        Assert.assertEquals(list.size(), 4);
    }

    @Test
    public void containsTest() {
        Assert.assertTrue(list.contains(-45));
        Assert.assertTrue(list.contains(null));
        Assert.assertFalse(list.contains(125));
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

    @Test
    public void addTest() {
        list.add(133);
        Assert.assertArrayEquals(list.toArray(), new Object[]{25, null, -45, 4, 133});
    }

    @Test
    public void addNullTest() {
        list.add(null);
        Assert.assertArrayEquals(list.toArray(), new Object[]{25, null, -45, 4, null});
    }

    /** remove(1), remove(0), remove(size-1) */
    @Test
    public void removeIndexTest() {
        Assert.assertNull(list.remove(1));
        Assert.assertEquals(list.remove(0), new Integer(25));
        Assert.assertEquals(list.remove(list.size()-1), new Integer(4));
        Assert.assertArrayEquals(list.toArray(), new Object[]{-45});
    }

    /** remove(-1) */
    @Test(expected = IndexOutOfBoundsException.class)
    public void removeNegIndexTest() {
        list.remove(-1);
    }

    /** remove(size) */
    @Test(expected = IndexOutOfBoundsException.class)
    public void removeBigIndexTest() {
        list.remove(list.size());
    }

    @Test
    public void removeElemTest() {
        Assert.assertTrue(list.remove(new Integer(25)));
        Assert.assertTrue(list.remove(null));
        Assert.assertFalse(list.remove(new Integer(125)));
        Assert.assertArrayEquals(list.toArray(), new Object[]{-45, 4});
    }

    @Test
    public void removeElemAllTest() {
        Assert.assertTrue(list.remove(new Integer(25)));
        Assert.assertTrue(list.remove(null));
        Assert.assertTrue(list.remove(new Integer(-45)));
        Assert.assertTrue(list.remove(new Integer(4)));
        Assert.assertEquals(list.size(), 0);
    }

    @Test
    public void clearTest() {
        list.clear();
        list.add(135);
        list.insert(0, 111);
        Assert.assertArrayEquals(list.toArray(), new Object[]{111, 135});
    }

    @Test
    public void iteratorTest() {
        Object[] arr = new Object[list.size()];
        int index = 0;
        for (Integer i : list) {
            arr[index] = i;
            index++;
        }
        Assert.assertArrayEquals(list.toArray(), arr);
    }

    @Test(expected = ConcurrentModificationException.class)
    public void exceptionIteratorTest() {
        for (Integer i : list) {
            list.remove(0);
        }
    }
}
