package L08IteratorsAndComparators.E09LinkedList;

import java.util.Iterator;
import java.util.function.Consumer;

public class LinkedList<T> implements Iterable<T> {
    private int size = 0;
    private Node head = null;
    private Node tail = null;

    @Override
    public Iterator<T> iterator() {
        return new listIterator();
    }

    private class listIterator implements Iterator<T> {
        int index = 0;
        Node currentNode = head;

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            Iterator.super.forEachRemaining(action);
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            T retVal = currentNode.value;
            currentNode = currentNode.next;
            index++;
            return retVal;
        }
    }

    private class Node {
        private final T value;
        private Node next = null;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    public void add(T value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else if (size == 1) {
            tail = newNode;
            head.next = tail;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public boolean remove(T value) {
        Node currentNode = head;
        for (int i = 0; i < size; i++) {
            if (currentNode.value == value) {
                removeFirst();
                return true;
            }

            if (currentNode.next != null && currentNode.next.value == value) {
                if (currentNode.next.next == null) {
                    removeLast();
                } else {
                    currentNode.next = currentNode.next.next;
                    size--;
                }
                return true;
            }
            if (currentNode.next != null) {
                currentNode = currentNode.next;
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    private void removeFirst() {
        if (size == 1) {
            head = null;
            return;
        }
        head = head.next;
        size--;
    }

    private void removeLast() {
        if (size == 1) {
            removeFirst();
            return;
        }
        Node node = head;
        for (int i = 0; i < size - 2; i++) {
            node = node.next;
        }
        node.next = null;
        tail = node;
        size--;
    }
}
