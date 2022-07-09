package lecture04;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class E11ArrayManipulatorTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void exchange() {
        int[] source = {1, 2, 3, 4, 5, 6, 7, 8};
        int index = 1;
        int[] expectedResult = {3, 4, 5, 6, 7, 8, 1, 2};
        E11ArrayManipulator.exchange(source, index);
        assertArrayEquals(expectedResult, source);
    }

    @Test
    void exchange1() {
        int[] source = {1, 2, 3, 4, 5, 6, 7, 8};
        int index = 5;
        int[] expectedResult = {7, 8, 1, 2, 3, 4, 5, 6};
        E11ArrayManipulator.exchange(source, index);
        assertArrayEquals(expectedResult, source);
    }

    @Test
    void exchange2() {
        int[] source = {1, 2, 3, 4, 5, 6, 7, 8};
        int index = 0;
        int[] expectedResult = {2, 3, 4, 5, 6, 7, 8, 1};
        E11ArrayManipulator.exchange(source, index);
        assertArrayEquals(expectedResult, source);
    }

    @Test
    void exchange3() {
        int[] source = {1, 2, 3, 4, 5, 6, 7, 8};
        int index = -1;
        E11ArrayManipulator.exchange(source, index);
        assertEquals("Invalid index", outputStreamCaptor.toString().trim());
    }

    @Test
    void exchange4() {
        int[] source = {1, 2, 3, 4, 5, 6, 7, 8};
        int index = 15;
        E11ArrayManipulator.exchange(source, index);
        assertEquals("Invalid index", outputStreamCaptor.toString().trim());
    }

    @Test
    void maxEven1() {
        int[] source = {1, 2, 3, 4, 5, 6, 7, 8};
        E11ArrayManipulator.maxEven(source);
        assertEquals("7", outputStreamCaptor.toString().trim());
    }

    @Test
    void maxEven2() {
        int[] source = {1, 3, 5, 7};
        E11ArrayManipulator.maxEven(source);
        assertEquals("No matches", outputStreamCaptor.toString().trim());
    }

    @Test
    void maxEven3() {
        int[] source = {4, 8, 12, 2, 9};
        E11ArrayManipulator.maxEven(source);
        assertEquals("2", outputStreamCaptor.toString().trim());
    }

    @Test
    void maxEven4() {
        int[] source = {4, 8, 12, 2, 12};
        E11ArrayManipulator.maxEven(source);
        assertEquals("4", outputStreamCaptor.toString().trim());
    }

    @Test
    void maxOdd1() {
        int[] source = {1, 2, 3, 4, 5, 6, 7, 8};
        E11ArrayManipulator.maxOdd(source);
        assertEquals("6", outputStreamCaptor.toString().trim());
    }

    @Test
    void maxOdd2() {
        int[] source = {2, 24, 6, 8};
        E11ArrayManipulator.maxOdd(source);
        assertEquals("No matches", outputStreamCaptor.toString().trim());
    }

    @Test
    void maxOdd3() {
        int[] source = {4, 3, 11, 5, 9};
        E11ArrayManipulator.maxOdd(source);
        assertEquals("2", outputStreamCaptor.toString().trim());
    }

    @Test
    void maxOdd4() {
        int[] source = {4, 3, 11, 5, 11};
        E11ArrayManipulator.maxOdd(source);
        assertEquals("4", outputStreamCaptor.toString().trim());
    }

    @Test
    void minEven1() {
        int[] source = {1, 2, 3, 4, 5, 6, 7, 8};
        E11ArrayManipulator.minEven(source);
        assertEquals("1", outputStreamCaptor.toString().trim());
    }

    @Test
    void minEven2() {
        int[] source = {1, 3, 5, 7};
        E11ArrayManipulator.minEven(source);
        assertEquals("No matches", outputStreamCaptor.toString().trim());
    }

    @Test
    void minEven3() {
        int[] source = {4, 8, 12, 2, 9};
        E11ArrayManipulator.minEven(source);
        assertEquals("3", outputStreamCaptor.toString().trim());
    }

    @Test
    void minEven4() {
        int[] source = {4, 8, 2, 2, 12};
        E11ArrayManipulator.minEven(source);
        assertEquals("3", outputStreamCaptor.toString().trim());
    }


    @Test
    void minOdd1() {
        int[] source = {1, 2, 3, 4, 5, 6, 7, 8};
        E11ArrayManipulator.minOdd(source);
        assertEquals("0", outputStreamCaptor.toString().trim());
    }

    @Test
    void minOdd2() {
        int[] source = {2, 24, 6, 8};
        E11ArrayManipulator.minOdd(source);
        assertEquals("No matches", outputStreamCaptor.toString().trim());
    }

    @Test
    void minOdd3() {
        int[] source = {4, 3, 11, 5, 9};
        E11ArrayManipulator.minOdd(source);
        assertEquals("1", outputStreamCaptor.toString().trim());
    }

    @Test
    void minOdd4() {
        int[] source = {4, 3, 3, 5, 11};
        E11ArrayManipulator.minOdd(source);
        assertEquals("2", outputStreamCaptor.toString().trim());
    }

    @Test
    void firstNOdd1() {
        int[] source = {4, 3, 3, 5, 11};
        E11ArrayManipulator.firstNOdd(source, 2);
        assertEquals("[3, 3]", outputStreamCaptor.toString().trim());
    }

    @Test
    void firstNOdd2() {
        int[] source = {1, 3, 3, 5, 11};
        E11ArrayManipulator.firstNOdd(source, 2);
        assertEquals("[1, 3]", outputStreamCaptor.toString().trim());
    }

    @Test
    void firstNOdd3() {
        int[] source = {2, 4, 8, 5, 11};
        E11ArrayManipulator.firstNOdd(source, 2);
        assertEquals("[5, 11]", outputStreamCaptor.toString().trim());
    }

    @Test
    void firstNOdd4() {
        int[] source = {2, 3, 8, 5, 11};
        E11ArrayManipulator.firstNOdd(source, 5);
        assertEquals("[3, 5, 11]", outputStreamCaptor.toString().trim());
    }

    @Test
    void firstNOdd5() {
        int[] source = {2, 3, 8, 5, 11};
        E11ArrayManipulator.firstNOdd(source, 6);
        assertEquals("Invalid count", outputStreamCaptor.toString().trim());
    }

    @Test
    void firstNOdd6() {
        int[] source = {2, 4, 8, 12, 16};
        E11ArrayManipulator.firstNOdd(source, 2);
        assertEquals("[]", outputStreamCaptor.toString().trim());
    }

    @Test
    void firstNEven1() {
        int[] source = {4, 3, 3, 8, 11};
        E11ArrayManipulator.firstNEven(source, 2);
        assertEquals("[4, 8]", outputStreamCaptor.toString().trim());
    }

    @Test
    void firstNEven2() {
        int[] source = {2, 4, 3, 5, 11};
        E11ArrayManipulator.firstNEven(source, 2);
        assertEquals("[2, 4]", outputStreamCaptor.toString().trim());
    }

    @Test
    void firstNEven3() {
        int[] source = {2, 4, 8, 5, 11};
        E11ArrayManipulator.firstNEven(source, 2);
        assertEquals("[2, 4]", outputStreamCaptor.toString().trim());
    }

    @Test
    void firstNEven4() {
        int[] source = {2, 2, 8, 5, 11};
        E11ArrayManipulator.firstNEven(source, 5);
        assertEquals("[2, 2, 8]", outputStreamCaptor.toString().trim());
    }

    @Test
    void firstNEven5() {
        int[] source = {2, 3, 8, 5, 11};
        E11ArrayManipulator.firstNEven(source, 6);
        assertEquals("Invalid count", outputStreamCaptor.toString().trim());
    }

    @Test
    void firstNEven6() {
        int[] source = {1, 3, 5, 9, 11, 13};
        E11ArrayManipulator.firstNEven(source, 2);
        assertEquals("[]", outputStreamCaptor.toString().trim());
    }

    @Test
    void reverseArray1() {
        int[] source = {1, 3, 5, 9, 11, 13};
        int[] expected = {13, 11, 9, 5, 3, 1};
        int[] returnArr = E11ArrayManipulator.reverseArray(source);
        assertArrayEquals(expected, returnArr);
    }


    @Test
    void lastNOdd1() {
        int[] source = {4, 3, 3, 5, 11};
        E11ArrayManipulator.lastNOdd(source, 2);
        assertEquals("[5, 11]", outputStreamCaptor.toString().trim());
    }

    @Test
    void lastNOdd2() {
        int[] source = {1, 3, 3, 5, 11};
        E11ArrayManipulator.lastNOdd(source, 2);
        assertEquals("[5, 11]", outputStreamCaptor.toString().trim());
    }

    @Test
    void lastNOdd3() {
        int[] source = {2, 4, 8, 5, 11};
        E11ArrayManipulator.lastNOdd(source, 2);
        assertEquals("[5, 11]", outputStreamCaptor.toString().trim());
    }

    @Test
    void lastNOdd4() {
        int[] source = {2, 3, 8, 5, 11};
        E11ArrayManipulator.lastNOdd(source, 5);
        assertEquals("[3, 5, 11]", outputStreamCaptor.toString().trim());
    }

    @Test
    void lastNOdd5() {
        int[] source = {2, 3, 8, 5, 11};
        E11ArrayManipulator.lastNOdd(source, 6);
        assertEquals("Invalid count", outputStreamCaptor.toString().trim());
    }

    @Test
    void lastNOdd6() {
        int[] source = {2, 4, 8, 12, 16};
        E11ArrayManipulator.lastNOdd(source, 2);
        assertEquals("[]", outputStreamCaptor.toString().trim());
    }


    @Test
    void LastNEven1() {
        int[] source = {4, 3, 3, 8, 11};
        E11ArrayManipulator.lastNEven(source, 2);
        assertEquals("[4, 8]", outputStreamCaptor.toString().trim());
    }

    @Test
    void LastNEven2() {
        int[] source = {2, 4, 3, 5, 11};
        E11ArrayManipulator.lastNEven(source, 2);
        assertEquals("[2, 4]", outputStreamCaptor.toString().trim());
    }

    @Test
    void LastNEven3() {
        int[] source = {2, 4, 8, 5, 11};
        E11ArrayManipulator.lastNEven(source, 2);
        assertEquals("[4, 8]", outputStreamCaptor.toString().trim());
    }

    @Test
    void LastNEven4() {
        int[] source = {2, 2, 8, 5, 11};
        E11ArrayManipulator.lastNEven(source, 5);
        assertEquals("[2, 2, 8]", outputStreamCaptor.toString().trim());
    }

    @Test
    void LastNEven5() {
        int[] source = {2, 3, 8, 5, 11};
        E11ArrayManipulator.lastNEven(source, 6);
        assertEquals("Invalid count", outputStreamCaptor.toString().trim());
    }

    @Test
    void LastNEven6() {
        int[] source = {1, 3, 5, 9, 11, 13};
        E11ArrayManipulator.lastNEven(source, 2);
        assertEquals("[]", outputStreamCaptor.toString().trim());
    }

    @Test
    void reverseArray3() {
        int[] source = {1, 3, 5, 9, 11, 13};
        int[] result = {13, 11, 9, 5, 3, 1};
        int[] output = E11ArrayManipulator.reverseArray(source);
        assertArrayEquals(result, output);
    }

    @Test
    void reverseArray2() {
        int[] source = {};
        int[] result = {};
        int[] output = E11ArrayManipulator.reverseArray(source);
        assertArrayEquals(result, output);
    }
}