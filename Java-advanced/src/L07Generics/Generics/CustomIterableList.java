package L07Generics.Generics;

import java.util.Iterator;
import java.util.function.Consumer;

public class CustomIterableList<T extends Comparable<T>> extends CustomList<T> implements Iterable<T> {


    @Override
    public Iterator<T> iterator() {
        return new CustomIterator();
    }

    private final class CustomIterator implements Iterator<T> {
        int currentItem = 0;

        @Override
        public boolean hasNext() {
            return currentItem < list.size();
        }


        @Override
        public T next() {
            T item = list.get(currentItem);
            currentItem++;
            return item;
        }

    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterable.super.forEach(action);
    }
}
