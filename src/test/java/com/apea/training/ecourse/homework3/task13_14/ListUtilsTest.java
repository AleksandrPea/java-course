package com.apea.training.ecourse.homework3.task13_14;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.apea.training.ecourse.homework3.task13_14.ListUtils.*;

public class ListUtilsTest {

    private List<Double> list = new ArrayList<>();

    private Comparator<Number> descNumComp = (o1, o2) -> {
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            return (int) (o2.doubleValue() - o1.doubleValue());
    };

    public ListUtilsTest() {
        list.add(13.);
        list.add(-24.);
        list.add(44.);
        list.add(0.);
        list.add(-13.);
        list.add(13.);
        list.add(5.3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkOneNullArgumentTest() {
        checkNullArguments(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkNullArgumentsTest() {
        checkNullArguments(new Object(), null, new Object());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void checkNegIndexTest() {
        checkIndexRange(10, -5, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkWrongIndexTest() {
        checkIndexRange(20, 10, 2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void checkBigIndexTest() {checkIndexRange(1, 0, 5);}

    @Test
    public void sortAscendingTest() {
        sort(list, Double::compareTo);
        Assert.assertArrayEquals(list.toArray(), new Object[]{-24., -13., 0., 5.3, 13., 13., 44.});
    }

    /** Comparing with {@link #descNumComp} */
    @Test
    public void sortDescendingWithNullTest() {
        list.add(null);
        sort(list, descNumComp);
        Assert.assertArrayEquals(list.toArray(), new Object[]{44., 13., 13., 5.3, 0., -13., -24., null});
    }

    @Test
    public void unionAndSortTest() {
        List<Number> newList = new ArrayList<>();
        newList.add(122.);
        newList.add(-122.);
        newList.add(25.);
        List<Number> unionList = unionAndSort(list, newList, descNumComp);
        Assert.assertArrayEquals(unionList.toArray(),
                new Object[]{122., 44., 25., 13., 13., 5.3,  0., -13., -24., -122.});
    }
}
