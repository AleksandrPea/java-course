package com.apea.training.ecourse.homework2.task9;

import com.apea.training.ecourse.homework2.task8.MyList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class MyLinkedList<E> implements MyList<E> {

    private Header<E> header;
    private int size;

    public MyLinkedList() {
        this.header = new Header<>(null, null);
        size = 0;
    }

    @Override
    public E get(int index) {
        return getNode(index).item;
    }

    @Override
    public void insert(int index, E elem) {
        if (index == 0) {
            Node<E> newNode = new Node<>(null, elem, header.first);
            if (size() == 0) {
                header.last = newNode;
            } else {
                header.first.prev = newNode;
            }
            header.first = newNode;
        } else if (index == size()) {
            Node<E> newNode = new Node<>(header.last, elem, null);
            header.last.next = newNode;
            header.last = newNode;
        } else {
            Node<E> node = getNode(index);
            Node<E> newNode = new Node<>(node.prev, elem, node);
            node.prev.next = newNode;
            node.prev = newNode;
        }
        size++;
    }

    @Override
    public E remove(int index) {
        if (index == size()) {
            throw new IndexOutOfBoundsException("index =" + index + "; size =" + size());
        }
        Node<E> nodeToRemove;
        if (index == 0) {
            nodeToRemove = header.first;
            header.first = header.first.next;
        } else if (index == size() - 1) {
            nodeToRemove = header.last;
            header.last = header.last.prev;
        } else {
            nodeToRemove = getNode(index);
            nodeToRemove.prev.next = nodeToRemove.next;
            nodeToRemove.next.prev = nodeToRemove.prev;
        }
        size--;
        return nodeToRemove.item;
    }

    @Override
    public boolean remove(E elem) {
        Node<E> nodeToRemove = getNode(elem);
        if (nodeToRemove == null) {
            return false;
        }
        if (size() == 1) {
            header.first = null;
            header.last = null;
        } else if (nodeToRemove.prev == null) {
            header.first = nodeToRemove.next;
            nodeToRemove.next.prev = null;
        } else if (nodeToRemove.next == null) {
            header.last = nodeToRemove.prev;
            nodeToRemove.prev.next = null;
        } else {
            nodeToRemove.prev.next = nodeToRemove.next;
            nodeToRemove.next.prev = nodeToRemove.prev;
        }
        size--;
        return true;
    }

    @Override
    public boolean contains(E elem) {
        return getNode(elem) != null;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size()];
        Node<E> current = header.first;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = current.item;
            current = current.next;
        }
        return arr;
    }

    @Override
    public int size() {
        return size;
    }

    private Node<E> getNode(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("index =" + index + "; size =" + size());
        }
        Node<E> current;
        if (index < size() / 2) {
            current = header.first;
            for (int counter = index; counter > 0; counter--) {
                current = current.next;
            }
        } else {
            current = header.last;
            for (int counter = size() - index - 1; counter > 0; counter--) {
                current = current.prev;
            }
        }
        return current;
    }

    /** @return node with elem or null if it doesn't exist */
    private Node<E> getNode(E elem) {
        Node<E> current = header.first;
        while (current != null &&
                ((elem == null) ? current.item != null : !elem.equals(current.item))) {
            current = current.next;
        }
        return current;
    }
    @Override
    public Iterator<E> iterator() {
        return new MyIterator<E>();
    }

    private class MyIterator<E> implements Iterator<E> {

        private int currentIndex = -1;
        private Node<E> nextNode = (Node<E>) header.first;
        private int initSize = size();

        @Override
        public boolean hasNext() {
            return currentIndex < size()-1;
        }

        @Override
        public E next() {
            if (size() != initSize) {
                throw new ConcurrentModificationException();
            }
            currentIndex++;
            E elem = nextNode.item;
            nextNode = nextNode.next;
            return elem;
        }
    }

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private static class Header<E> {
        Node<E> first;
        Node<E> last;

        Header(Node<E> first, Node<E> last) {
            this.first = first;
            this.last = last;
        }
    }
}
