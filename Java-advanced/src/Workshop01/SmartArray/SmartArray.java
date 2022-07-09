package Workshop01.SmartArray;

import java.util.Arrays;
import java.util.function.Consumer;

public class SmartArray {
    private final int INITIAL_SIZE = 2;
    private final int EXPAND_FACTOR = 2;
    private final int SHRINK_FACTOR = 4;

    private int[] values;
    private int size = 0;

    public SmartArray() {
        this.values = new int[INITIAL_SIZE];
    }

    private void expand() {
        if (values.length <= size) {
            int[] newValues = new int[values.length * EXPAND_FACTOR];
            System.arraycopy(values, 0, newValues, 0, values.length);
            values = newValues;
        }
    }

    private void shrink() {
        if (values.length > size * SHRINK_FACTOR) {
            int shrinkTarget = Math.max(INITIAL_SIZE, values.length / SHRINK_FACTOR);
            int[] newValues = new int[shrinkTarget];
            System.arraycopy(values, 0, newValues, 0, size);
            values = newValues;
        }
    }

    public void add(int value) {
        add(size, value);
    }

    public void add(int index, int value) {
        expand();

        while (size < index) {
            size++;
            expand();
        }
        if (size - index >= 0) System.arraycopy(values, index, values, index + 1, size - index);
        values[index] = value;
        size++;
    }

    public boolean contains(int value) {
        return Arrays.stream(values).anyMatch(e -> e == value);
    }

    public void forEach(Consumer<Integer> c) {
        Arrays.stream(values).forEach(c::accept);
    }

    public int get(int index) {
        try {
            return values[index];
        } catch (Exception e) {
            throw new IndexOutOfBoundsException();
        }
    }

    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (values[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public void remove(int index) {
        if (index > size - 1 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (size - 1 - index >= 0) System.arraycopy(values, index + 1, values, index, size - 1 - index);
        values[size - 1] = 0;
        size--;
        shrink();
    }

    public void removeFirst(int value) {
        for (int i = 0; i < size; i++) {
            if (values[i] == value) {
                remove(i);
                break;
            }
        }
    }

    @Override
    public String toString() {
        int[] printArray = new int[size];
        System.arraycopy(values, 0, printArray, 0, size);
        return Arrays.toString(printArray);
    }
}
