package lecture08UnitTesting.p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;

public class TestExtendedDatabase {
    private Database database = null;
    private final Person[] people = new Person[]{
            new Person(100, "Ivan"),
            new Person(202, "Dragan"),
            new Person(303, "Petkan"),
            new Person(4000, "Trifon")};

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(people);
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
        database = new Database(new Person[17]);
    }

    @Test
    public void testDatabaseAddElement() throws OperationNotSupportedException {
        Person addedPerson = new Person(9999, "Plamen");
        database.add(addedPerson);

        Person[] expectedElements = Arrays.copyOf(people, 5);
        expectedElements[4] = addedPerson;

        Assert.assertArrayEquals(expectedElements, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseThrowsExceptionAddingNullElement() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testDatabaseRemoveElement() throws OperationNotSupportedException {
        database.remove();
        Person[] expectedElements = Arrays.copyOf(people, 3);
        Assert.assertArrayEquals(expectedElements, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseThrowsExceptionRemovingFromEmptyDatabase() throws OperationNotSupportedException {
        while (true) {
            database.remove();
        }
    }

    @Test
    public void testDatabaseGetElements() {
        Assert.assertArrayEquals(this.people, database.getElements());
    }

    @Test
    public void testDatabaseFindByUsername() throws OperationNotSupportedException {
        Person searchedPerson = people[0];
        String searchedUsername = people[0].getUsername();
        Person foundPerson = database.findByUsername(searchedUsername);
        Assert.assertEquals(searchedPerson,foundPerson);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseFindByUsernameThrowsExceptionWhenUsernameIsNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseFindByUsernameThrowsExceptionNotFound() throws OperationNotSupportedException {
        database.findByUsername("searchedUsername");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseFindByUsernameThrowsExceptionDuplicateUsername() throws OperationNotSupportedException {
        database.add(people[0]);
        database.findByUsername(people[0].getUsername());
    }

    @Test
    public void testDatabaseFindById() throws OperationNotSupportedException {
        Person searchedPerson = people[0];
        long id = people[0].getId();
        Person foundPerson = database.findById(id);
        Assert.assertEquals(searchedPerson,foundPerson);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseFindByIdThrowsExceptionNotFound() throws OperationNotSupportedException {
        database.findById(987654321);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseFindByIdThrowsExceptionDuplicateId() throws OperationNotSupportedException {
        database.add(people[0]);
        database.findById(people[0].getId());
    }

}
