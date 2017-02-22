package com.apea.training.ecourse.homework3.task15;

import com.apea.training.ecourse.homework3.task13_14.ListUtils;

import java.util.*;

public class MyPriorityQueue<E> implements Queue<E> {

    private MyHeap<E> heap;

    protected MyPriorityQueue(Comparator<? super E> comparator) {
        heap = new MyHeap<E>(comparator);
    }

    public static <E> MyPriorityQueue<E> newInstance(Comparator<? super E> comparator) {
        if (comparator == null) {
            throw new IllegalArgumentException("Null comparator");
        }
        return new MyPriorityQueue<E>(comparator);
    }

    @Override
    public boolean add(E e) {
        heap.insert(e);
        return true;
    }

    @Override
    public boolean offer(E e) {
        heap.insert(e);
        return true;
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return heap.extractMaximum();
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return heap.extractMaximum();
    }

    @Override
    public E element() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return heap.maximum();
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return heap.maximum();
    }

    @Override
    public int size() {
        return heap.array.size();
    }

    @Override
    public boolean isEmpty() {
        return heap.array.size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return heap.array.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIter<>(heap);
    }

    @Override
    public Object[] toArray() {
        return heap.array.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return heap.array.toArray(a);
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("remove");
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return heap.array.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        heap.array.addAll(c);
        heap.buildMaxHeap();
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result = heap.array.removeAll(c);
        heap.buildMaxHeap();
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean result = heap.array.retainAll(c);
        heap.buildMaxHeap();
        return result;
    }

    @Override
    public void clear() {
        heap.array.clear();
    }

    private static class MyIter<E> implements Iterator<E> {
        private Iterator<E> arrayIterator;

        MyIter(MyHeap<E> heap) {
            this.arrayIterator = heap.array.iterator();
        }
        @Override
        public boolean hasNext() {
            return arrayIterator.hasNext();
        }

        @Override
        public E next() {
            return arrayIterator.next();
        }
    }

    protected static class MyHeap<E> {

        protected List<E> array = new ArrayList<>();
        private Comparator<? super E> comparator;

        protected MyHeap(Comparator<? super E> comparator) {
            this.comparator = comparator;
        }

        private void maxHeapify(int index) {
            int l = leftIndex(index);
            int r = rightIndex(index);
            int largest;
            if (l < array.size() &&
                    comparator.compare(array.get(l),array.get(index)) > 0) {
                largest = l;
            } else {
                largest = index;
            }
            if (r < array.size() &&
                    comparator.compare(array.get(r),array.get(largest)) > 0) {
                largest = r;
            }
            if (largest != index) {
                ListUtils.swap(array, index, largest);
                maxHeapify(largest);
            }
        }

        protected void buildMaxHeap() {
            for (int i = (array.size()-1)/2; i >= 0; i--) {
                maxHeapify(i);
            }
        }

        protected void insert(E element) {
            array.add(element);
            int i = array.size() - 1;
            int parent = parentIndex(i);
            while (i > 0 && comparator.compare(array.get(parent), array.get(i)) < 0) {
                ListUtils.swap(array, i, parent);
                i = parent;
                parent = parentIndex(i);
            }
        }

        protected E maximum() {
            return array.get(0);
        }

        protected E extractMaximum() {
            E max = array.set(0, array.remove(array.size()-1));
            maxHeapify(0);
            return max;
        }

        protected int parentIndex(int index) {
            return (index-1) >> 1;
        }

        protected int leftIndex(int index) {
            return (index << 1) + 1;
        }

        protected int rightIndex(int index) {
            return (index << 1) + 2;
        }
    }
}
