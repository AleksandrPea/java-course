package com.apea.training.ecourse.homework3.task13_14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListUtils {

    private ListUtils() {}

    /**
     * @param from including
     * @param to excluding
     */
    public static <E> void sort(List<E> list, int from, int to, Comparator<? super E> comparator) {
        checkNullArguments(list, comparator);
        checkIndexRange(list.size(), from ,to);
        quickSort(list, from, to, comparator);
    }

    public static <E> void sort(List<E> list, Comparator<? super E> comparator) {
        checkNullArguments(list, comparator);
        quickSort(list, 0, list.size(), comparator);
    }

    public static <E> List<E> unionAndSort(List<? extends E> list1, List<? extends E> list2, Comparator<? super E> comparator) {
        checkNullArguments(list1, list2, comparator);
        List<E> unionList = new ArrayList<>(list1.size() + list2.size());
        unionList.addAll(list1);
        unionList.addAll(list2);
        sort(unionList, comparator);
        return unionList;
    }

    private static <E> void quickSort(List<E> list, int from, int to, Comparator<? super E> comparator) {
        if (to - from >= 2) {
            int pivotIndex = from + (int) (Math.random() * (to - from));
            E pivot = list.get(pivotIndex);
            swap(list, from, pivotIndex);
            int i = from + 1;  // indicates first element from right part
            for (int j = i; j < to; j++) {
                if (comparator.compare(list.get(j), pivot) < 0) {
                    swap(list, i, j);
                    i++;
                }
            }
            swap(list, from, i-1); // placing pivot on its place
            quickSort(list, from, i-1, comparator);
            quickSort(list, i, to, comparator);
        }
    }

    public static void swap(List<?> list, int i1, int i2) {
        List l = list;
        Object elem1 = l.set(i1, l.get(i2));
        l.set(i2, elem1);
    }

    static void checkNullArguments(Object ... argument) {
        boolean hasNull = false;
        if (argument == null) { hasNull = true; }
        int i = 0;
        while (!hasNull && i < argument.length) {
            if (argument[i] == null) {
                hasNull = true;
            }
            i++;
        }
        if (hasNull) {
            throw new IllegalArgumentException("Your argument is null!");
        }
    }

    static void checkIndexRange(int size, int from, int to) {
        if (from > to) {
            throw new IllegalArgumentException("Wrong range from="+from +", to="+to);
        }
        if (from < 0) {
            throw new IndexOutOfBoundsException(""+from);
        }
        if (to > size) {
            throw new IndexOutOfBoundsException(""+to);
        }
    }
}
