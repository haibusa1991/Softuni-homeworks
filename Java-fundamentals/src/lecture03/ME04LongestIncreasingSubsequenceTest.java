package lecture03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ME04LongestIncreasingSubsequenceTest {

    @Test
    void sequence1() {
        String expected = "3 5 6 7 ";
        String input = "7 3 5 8 -1 0 6 7";
        String result = ME04LongestIncreasingSubsequence.getLongestSequence(input);
        assertEquals(expected, result);
    }

    @Test
    void sequence2() {
        String expected = "1 2 3 5 ";
        String input = "1 2 5 3 5 2 4 1";
        String result = ME04LongestIncreasingSubsequence.getLongestSequence(input);
        assertEquals(expected, result);
    }

    @Test
    void sequence3() {
        String expected = "0 1 2 3 4 5 6 ";
        String input = "0 10 20 30 30 40 1 50 2 3 4 5 6";
        String result = ME04LongestIncreasingSubsequence.getLongestSequence(input);
        assertEquals(expected, result);
    }

    @Test
    void sequence4() {
        String expected = "3 4 5 6 7 8 16 ";
        String input = "11 12 13 3 14 4 15 5 6 7 8 7 16 9 8";
        String result = ME04LongestIncreasingSubsequence.getLongestSequence(input);
        assertEquals(expected, result);
    }

    @Test
    void sequence5() {
        String expected = "3 5 7 8 9 11 ";
        String input = "3 14 5 12 15 7 8 9 11 10 1";
        String result = ME04LongestIncreasingSubsequence.getLongestSequence(input);
        assertEquals(expected, result);
    }

    @Test
    void sequence6() {
        String expected = "1 ";
        String input = "1";
        String result = ME04LongestIncreasingSubsequence.getLongestSequence(input);
        assertEquals(expected, result);
    }
}