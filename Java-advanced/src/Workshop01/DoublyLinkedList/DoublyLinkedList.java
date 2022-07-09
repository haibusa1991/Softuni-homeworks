package Workshop01.DoublyLinkedList;

import java.lang.reflect.Array;
import java.util.function.Consumer;

public class DoublyLinkedList<T> {
    private class Node {
        T value;
        Node prev = null;
        Node next = null;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public void addFirst(T value) {
        Node newNode = new Node(value);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public void addLast(T value) {
        if (size == 0) {
            addFirst(value);
        } else {
            Node newNode = new Node(value);
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    public T get(int index) {
        checkIndex(index);
        Node currentElement;

        if (index < (size / 2) + 1) {
            currentElement = head;
            for (int i = 0; i < index; i++) {
                currentElement = currentElement.next;
            }
            return currentElement.value;
        }

        currentElement = tail;
        for (int i = size; i > index + 1; i--) {
            currentElement = currentElement.prev;
        }
        return currentElement.value;
    }

    public void removeFirst() {
        head = head.next;
        head.prev = null;
        size--;
    }

    public void removeLast() {
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    private Node getNode(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Invalid index. Index cannot be less than 0 or greater than " + (size - 1));
        }
        Node currentElement;

        if (index < (size / 2) + 1) {
            currentElement = head;
            for (int i = 0; i < index; i++) {
                currentElement = currentElement.next;
            }
            return currentElement;
        }

        currentElement = tail;
        for (int i = size; i > index + 1; i--) {
            currentElement = currentElement.prev;
        }
        return currentElement;
    }

    public void remove(int index) {
        checkIndex(index);
        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size - 1) {
            removeLast();
            return;
        }
        Node currentNode = this.getNode(index);
        currentNode.prev.next = currentNode.next;
        currentNode.next.prev = currentNode.prev;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException("Invalid index. Index cannot be less than 0 or greater than " + (size - 1));
        }
    }

    public void forEach(Consumer<T> consumer) {
        Node currentNode = head;
        while (currentNode != null) {
            consumer.accept(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    public T[] toArray() {
        T[] arr = (T[]) Array.newInstance(head.value.getClass(), size);

        Node currentNode = head;
        for (int i = 0; i < size; i++) {
            arr[i] = currentNode.value;
            currentNode = currentNode.next;
        }
        return arr;
    }

}
