package L08IteratorsAndComparators.Iterators;

import java.util.Iterator;

public class Stack implements Iterable<Integer> {
    private class Node {

        private final int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

    }

    private Node topNode = null;

    public Stack(int... values) {
        push(values);
    }

    public void push(int... values) {
        for (int value : values) {
            this.push(value);
        }
    }

    private void push(int value) {
        Node newNode = new Node(value);
        newNode.next = topNode;
        topNode = newNode;
    }

    public int pop() {
        if (topNode == null) {
            throw new IllegalStateException("No elements");
        }
        int currentValue = topNode.value;
        topNode = topNode.next;
        return currentValue;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<Integer> {
        Node currentNode = topNode;

        @Override
        public boolean hasNext() {
            return !(currentNode == null);
        }

        @Override
        public Integer next() {
            int value = currentNode.value;
            currentNode = currentNode.next;
            return value;
        }
    }
}
