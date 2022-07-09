package L07Generics.Generics;

public class Box<T extends Comparable<T>> {
    private final T value;

    public Box(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.getClass().getName() + ": " + value;
    }

    public T getValue() {
        return value;
    }

    public int compareTo(Box<T> box) {
        return this.value.compareTo(box.getValue());
    }

}

