package lecture08UnitTesting.p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database = null;
    private final Integer[] elements = new Integer[]{0, 1, 2, 3, 4};

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(elements);
    }

    @Test
    public void testDatabaseInitializesArray() {
        Assert.assertNotEquals(null, database);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseThrowsExceptionWhenInitializedWithZeroElements() throws OperationNotSupportedException {
        database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseThrowsExceptionWhenInitializedWithMoreThanSixteenElements() throws OperationNotSupportedException {
        database = new Database(new Integer[17]);
    }

    @Test
    public void testDatabaseAddElement() throws OperationNotSupportedException {
        database.add(5);
        Integer[] expectedElements = new Integer[]{0, 1, 2, 3, 4, 5};
        Assert.assertArrayEquals(expectedElements, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseThrowsExceptionAddingNullElement() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testDatabaseRemoveElement() throws OperationNotSupportedException {
        database.remove();
        Integer[] expectedElements = new Integer[]{0, 1, 2, 3};
        Assert.assertArrayEquals(expectedElements, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseThrowsExceptionRemovingFromEmptyDatabase() throws OperationNotSupportedException {
        while (true){
            database.remove();
        }
    }

    @Test
    public void testDatabaseGetElements(){
        Assert.assertArrayEquals(this.elements,database.getElements());
    }

}
