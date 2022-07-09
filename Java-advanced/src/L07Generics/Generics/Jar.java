package L07Generics.Generics;

import java.util.ArrayDeque;

public class Jar<T> {
    ArrayDeque<T> elements = new ArrayDeque<>();

    public void add(T element) {
        elements.push(element);
    }

    public T remove() {
        return elements.pop();
    }
}
