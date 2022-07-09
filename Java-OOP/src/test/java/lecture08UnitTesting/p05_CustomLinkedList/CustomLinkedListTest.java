package lecture08UnitTesting.p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomLinkedListTest {
    private CustomLinkedList<String> list;
    private String[] elements = new String[]{"Ivan", "Dragan", "Petkan", "Trifon"};
    private String CUSTOM_NAME = "Plamen";

    @Before
    public void setUp() {
        list = new CustomLinkedList<>();
        for (String element : elements) {
            list.add(element);
        }
    }

    @Test
    public void testListDefaultConstructor() {
        list = new CustomLinkedList<>();
    }

    @Test
    public void testGet() {
        for (int i = 0; i < elements.length; i++) {
            Assert.assertEquals(elements[i], list.get(i));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetThrowsExceptionForIndexLessThanZero() {
        list.get(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetThrowsExceptionForIndexGreaterThanSize() {
        list.get(elements.length);
    }

    @Test
    public void testSet() {
        for (int i = 0; i < elements.length; i++) {
            list.set(i, CUSTOM_NAME);
            Assert.assertEquals(list.get(i), CUSTOM_NAME);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetThrowsExceptionForIndexLessThanZero() {
        list.set(-1, CUSTOM_NAME);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetThrowsExceptionForIndexGreaterThanSize() {
        list.set(elements.length, CUSTOM_NAME);
    }

    @Test
    public void testAdd() {
        list = new CustomLinkedList<>();
        Assert.assertEquals(0, list.getCount());
        for (int i = 0; i < elements.length; i++) {
            list.add(elements[i]);
            Assert.assertEquals(i + 1, list.getCount());
        }
    }

    @Test
    public void testRemoveAt() {
        String removedElement;
        String expectedElement;
        for (int i = 1; i < elements.length; i++) {
            removedElement = list.removeAt(1);
            expectedElement = elements[i];
            Assert.assertEquals(expectedElement, removedElement);
        }

        removedElement = list.removeAt(0);
        expectedElement = elements[0];
        Assert.assertEquals(expectedElement, removedElement);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtThrowsExceptionForIndexLessThanZero() {
        list.removeAt(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtThrowsExceptionForIndexGreaterThanSize() {
        list.removeAt(elements.length);
    }

    @Test
    public void testRemove() {
        for (String element : elements) {
            int result = list.remove(element);
            Assert.assertEquals(0, result);
        }
    }

    @Test
    public void testRemoveElementNotFound() {
        Assert.assertEquals(-1, list.remove(CUSTOM_NAME));
    }

    @Test
    public void testIndexOf() {
        for (int i = 0; i < elements.length; i++) {
            Assert.assertEquals(i, list.indexOf(elements[i]));
        }
    }

    @Test
    public void testIndexOfElementNotFound() {
        Assert.assertEquals(-1, list.indexOf(CUSTOM_NAME));
    }

    @Test
    public void testContains(){
        for (String element : elements) {
            Assert.assertTrue(list.contains(element));
        }
    }

    @Test
    public void testContainsElementNotFound(){
            Assert.assertFalse(list.contains(CUSTOM_NAME));
    }

}
