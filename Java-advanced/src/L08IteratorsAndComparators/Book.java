package L08IteratorsAndComparators;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Book implements Comparable<Book> {
    private String title;
    private int year;
    private List<String> authors;


    public Book(String title, int year, String... authors) {
        setTitle(title);
        setYear(year);
        setAuthors(authors);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private void setAuthors(String... authors) {
        this.authors = Arrays.stream(authors).collect(Collectors.toList());
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    @Override
    public int compareTo(Book other) {
        int result = this.getTitle().compareTo(other.getTitle());
        if (result == 0) {
            result = Integer.compare(this.getYear(), other.getYear());
        }
        return result;
    }
}
