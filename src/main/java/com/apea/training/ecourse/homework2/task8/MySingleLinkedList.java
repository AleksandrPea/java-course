package com.apea.training.ecourse.homework2.task8;

public class MySingleLinkedList<E> implements MyList<E> {

    private Node<E> first;
    private int size;

    public MySingleLinkedList() {
        this.first = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        return getNode(index).item;
    }

    @Override
    public void insert(int index, E elem) {
        if (index == 0) {
            first = new Node<>(elem, first);
        } else {
            Node<E> node = getNode(index - 1);
            node.next = new Node<>(elem, node.next);
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
            nodeToRemove = first;
            first = first.next;
        } else {
            Node<E> node = getNode(index - 1);
            nodeToRemove = node.next;
            node.next = nodeToRemove.next;
        }
        size--;
        return nodeToRemove.item;
    }

    @Override
    public boolean remove(E elem) {
        Node[] nodes = getNodeWithNeighbor(elem);
        if (nodes == null) {
            return false;
        }
        if (nodes[0] != null) {
            nodes[0].next = nodes[1].next;
        } else {
            first = nodes[1].next;
        }
        size--;
        return true;
    }

    @Override
    public boolean contains(E elem) {
        return getNodeWithNeighbor(elem) != null;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size()];
        Node<E> current = first;
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
        Node<E> current = first;
        for (int cursor = index; cursor > 0; cursor--) {
            current = current.next;
        }
        return current;
    }

    /**
     * @return [1] - node with element elem and in [0] it's left neighbor.
     * If there is no node with elem, returns null.
     */
    private Node[] getNodeWithNeighbor(E elem) {
        Node<E> leftNeighbor = null;
        Node<E> current = first;
        while (current != null &&
                ((elem == null) ? current.item != null : !elem.equals(current.item))) {
            leftNeighbor = current;
            current = leftNeighbor.next;
        }
        if (current == null) {
            return null;
        }
        return new Node[]{leftNeighbor, current};
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

}
