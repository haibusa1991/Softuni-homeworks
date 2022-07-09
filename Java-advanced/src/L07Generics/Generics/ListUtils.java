package L07Generics.Generics;

import java.util.List;

public class ListUtils {

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return list.stream()
                .min(Comparable::compareTo)
                .get();
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return list.stream()
                .max(Comparable::compareTo)
                .get();
    }

    public static <T> void swap(List<T> list, int index1, int index2) {
        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    public static <T extends Comparable<T>> int greaterThan(List<Box<T>> list, Box<T> val) {
        int numGreater = 0;
        for (Box<T> element : list) {
            if (element.compareTo(val) > 0) {
                numGreater++;
            }
        }
        return numGreater;
    }

    public static <T extends Comparable<T>> int greaterThan(List<T> list, T val) {
        int numGreater = 0;
        for (T element : list) {
            if (element.compareTo(val) > 0) {
                numGreater++;
            }
        }
        return numGreater;
    }

}

