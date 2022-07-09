package Workshop01.CustomStack;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomStack {
    private Node topNode = null;
    private int size=0;

    private static class Node {
        int value;
        Node prev = null;

        public Node(int value) {
            this.value = value;
        }
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.prev = topNode;
        topNode = newNode;
        size++;
    }

    public int pop() {
        checkIfValid();
        Node popNode = topNode;
        topNode = topNode.prev;
        size--;
        return popNode.value;
    }

    public int peek() {
        checkIfValid();
        return topNode.value;
    }

    private void checkIfValid() {
        if (topNode == null) {
            throw new NoSuchElementException();
        }
    }

    public void forEach(Consumer<Integer> c) {
        Node currentNode = topNode;
        while (currentNode != null) {
            c.accept(currentNode.value);
            currentNode = currentNode.prev;
        }

    }

}
