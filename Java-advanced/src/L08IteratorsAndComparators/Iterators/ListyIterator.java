package L08IteratorsAndComparators.Iterators;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private int index = 0;
    private List<String> items;

    public ListyIterator(String... items) {
        this.items = Arrays.asList(items);
    }

    @Override
    public Iterator<String> iterator() {
        return new ListyIter();
    }

    private class ListyIter implements Iterator<String> {
        int pointer = 0;

        @Override
        public boolean hasNext() {
            return pointer < items.size();
        }

        @Override
        public String next() {
            String next = items.get(pointer);
            pointer++;
            return next;
        }
    }

    public boolean move() {
        if (index == items.size() - 1) {
            return false;
        }
        index++;
        return true;
    }

    public void print() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");
        }
        System.out.println(items.get(index));
    }

    public boolean hasNext() {
        return index < items.size() - 1;
    }
}
