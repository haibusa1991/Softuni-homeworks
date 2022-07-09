package L07Generics.Generics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomList<T extends Comparable<T> > {
    protected List<T> list = new ArrayList<>();

    public void add(T item) {
        list.add(item);
    }

    public void remove(int index) {
        list.remove(index);
    }

    public boolean contains(T item) {
        return list.contains(item);
    }

    public void swap(int index1, int index2) {
        ListUtils.swap(list, index1, index2);
    }

    public int greaterThan(T item) {
        return ListUtils.greaterThan(list, item);
    }

    public T getMax() {
        return ListUtils.getMax(list);
    }

    public T getMin() {
        return ListUtils.getMin(list);
    }

    public void printAll() {
        list.forEach(System.out::println);
    }

    public void sort() {
        list = list.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }
}
