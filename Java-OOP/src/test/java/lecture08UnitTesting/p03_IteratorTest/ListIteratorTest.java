package lecture08UnitTesting.p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {

    private final String[] elements = new String[]
            {"Ivan", "Petkan", "Dragan", "Trifon"};
    private ListIterator listIterator;
    private final int numIterations = elements.length;

    @Before
    public void setUp() throws OperationNotSupportedException {
        listIterator = new ListIterator(elements);
    }

    @Test
    public void testListIteratorInitialize() throws OperationNotSupportedException {
        Assert.assertNotEquals(null, listIterator);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testListIteratorThrowsExceptionNoElements() throws OperationNotSupportedException {
        listIterator = new ListIterator(null);
    }

    @Test
    public void testListIteratorMove() {
        for (int i = 0; i < numIterations-1; i++) {
            Assert.assertTrue(listIterator.move());
        }
        Assert.assertFalse(listIterator.move());
    }

    @Test
    public void testListIteratorHasNext() {
        for (int i = 0; i < numIterations-1; i++) {
            Assert.assertTrue(listIterator.hasNext());
            Assert.assertTrue(listIterator.move());
        }
        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void testListIteratorPrint() {
        for (int i = 0; i < numIterations; i++) {
            Assert.assertEquals(elements[i], listIterator.print());
            listIterator.move();
        }
    }

    @Test(expected = IllegalStateException.class)
    public void testListIteratorPrintThrowsExceptionNoElements() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }
}
