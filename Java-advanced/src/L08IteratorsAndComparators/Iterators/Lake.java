package L08IteratorsAndComparators.Iterators;

import java.util.Iterator;

public class Lake implements Iterable<Integer> {
    private final int[] stones;

    public Lake(int... stones) {
        this.stones = stones;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    private class Frog implements Iterator<Integer> {
        int index = 0;
        boolean isSecondPass = false;

        @Override
        public boolean hasNext() {
            return index < stones.length;
        }

        @Override
        public Integer next() {
            int value = stones[index];
            index += 2;
            if (index >= stones.length && !isSecondPass) {
                isSecondPass = true;
                index = 1;
            }
            return value;

        }
    }
}
