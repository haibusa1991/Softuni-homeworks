package L08IteratorsAndComparators;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book b1, Book b2) {
        return b1.compareTo(b2);
    }
}
