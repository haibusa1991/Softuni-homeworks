package lecture08UnitTesting.p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTest {
    private final int[] SORTED_VALUES = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    private final int[] REVERSED_VALUES = new int[]{8, 7, 6, 5, 4, 3, 2, 1};
    private final int[] RANDOM_VALUES = new int[]{5, 1, 2, 3, 6, 7, 4, 8};

    private final int[] EXPECTED_VALUES_NO_DUPLICATES = new int[]{1, 2, 3, 4, 5, 6, 7, 8};


    private final int[] SORTED_DUPLICATE_VALUES = new int[]{1, 1, 2, 3, 4, 5, 5, 6, 7, 8, 8};
    private final int[] REVERSED_DUPLICATE_VALUES = new int[]{8, 8, 7, 6, 5, 5, 4, 3, 2, 1, 1};
    private final int[] RANDOM_DUPLICATE_VALUES = new int[]{8, 7, 5, 8, 6, 5, 3, 4, 1, 2, 1};

    private final int[] EXPECTED_VALUES_DUPLICATES = new int[]{1, 1, 2, 3, 4, 5, 5, 6, 7, 8, 8};

    @Test
    public void testSortedArray() {
        Bubble.sort(SORTED_VALUES);
        Assert.assertArrayEquals(SORTED_VALUES, EXPECTED_VALUES_NO_DUPLICATES);
    }

    @Test
    public void testReversedArray() {
        Bubble.sort(REVERSED_VALUES);
        Assert.assertArrayEquals(SORTED_VALUES, EXPECTED_VALUES_NO_DUPLICATES);
    }

    @Test
    public void testRandomArray() {
        Bubble.sort(RANDOM_VALUES);
        Assert.assertArrayEquals(SORTED_VALUES, EXPECTED_VALUES_NO_DUPLICATES);
    }

    @Test
    public void testSortedArrayDuplicates() {
        Bubble.sort(SORTED_DUPLICATE_VALUES);
        Assert.assertArrayEquals(SORTED_DUPLICATE_VALUES, EXPECTED_VALUES_DUPLICATES);
    }

    @Test
    public void testReversedArrayDuplicates() {
        Bubble.sort(REVERSED_DUPLICATE_VALUES);
        Assert.assertArrayEquals(REVERSED_DUPLICATE_VALUES, EXPECTED_VALUES_DUPLICATES);
    }

    @Test
    public void testRandomArrayDuplicates() {
        Bubble.sort(RANDOM_DUPLICATE_VALUES);
        Assert.assertArrayEquals(RANDOM_DUPLICATE_VALUES, EXPECTED_VALUES_DUPLICATES);
    }


}
