package L08IteratorsAndComparators;

import java.util.Iterator;
import java.util.function.Consumer;

public class Library<Book> implements Iterable<Book> {
    private Book[] books;

    private class LibIterator implements Iterator<Book> {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter<books.length;
        }

        @Override
        public Book next() {
            Book book = books[counter];
            counter++;
            return book;
        }
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }

    @Override
    public void forEach(Consumer<? super Book> action) {
        Iterable.super.forEach(action);
    }
}
