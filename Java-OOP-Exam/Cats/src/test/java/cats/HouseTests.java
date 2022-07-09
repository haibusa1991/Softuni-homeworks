package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseTests {
    private static final int VALID_CAPACITY = 15;
    private static final String VALID_NAME = "Valid name";
    private House house;


    @Before
    public void setUp() {
        this.house = new House(VALID_NAME, VALID_CAPACITY);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHouseThrowsExceptionCapacityLessThanZero() {
        house = new House(VALID_NAME, -1);
    }

    @Test(expected = NullPointerException.class)
    public void testHouseThrowsExceptionCNameIsNull() {
        house = new House(null, VALID_CAPACITY);
    }

    @Test(expected = NullPointerException.class)
    public void testHouseThrowsExceptionNameIsEmpty() {
        house = new House("   ", VALID_CAPACITY);
    }

    @Test
    public void testHouseCapacitySetsCorrectValue() {
        int expected = VALID_CAPACITY;
        int actual = house.getCapacity();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testHouseNameSetsCorrectValue() {
        String expected = VALID_NAME;
        String actual = house.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testHouseAddCatAddsCat() {
        Cat cat = new Cat("Maca");
        Cat cat2 = new Cat("Pisa");

        house.addCat(cat);
        house.addCat(cat2);

        int expected = 2;
        int actual = house.getCount();

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHouseAddCatThrowsExceptionWhenHouseIsFull() {
        house = new House(VALID_NAME, 1);

        Cat cat = new Cat("Maca");
        Cat cat2 = new Cat("Pisa");

        house.addCat(cat);
        house.addCat(cat2);

    }

    @Test
    public void testHouseRemoveCatRemovesCatFromHouse() {
        Cat cat = new Cat("Maca");
        Cat cat2 = new Cat("Pisa");

        house.addCat(cat);
        house.addCat(cat2);

        house.removeCat("Maca");
        int expected = 1;
        int actual = house.getCount();
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHouseRemoveCatThrowsExceptionWhenNameIsInvalid() {
        Cat cat = new Cat("Maca");
        Cat cat2 = new Cat("Pisa");

        house.addCat(cat);
        house.addCat(cat2);

        house.removeCat("Ivan");
    }

    @Test
    public void testHouseCatForSaleReturnsCat() {
        Cat cat = new Cat("Maca");
        Cat cat2 = new Cat("Pisa");

        house.addCat(cat);
        house.addCat(cat2);

        Cat soldCat = house.catForSale("Maca");
        Assert.assertEquals(cat, soldCat);
    }

    @Test
    public void testHouseCatForSaleReturnsCatNotHungry() {
        Cat cat = new Cat("Maca");
        cat.setHungry(true);
        house.addCat(cat);

        Cat soldCat = house.catForSale("Maca");
        Assert.assertFalse(soldCat.isHungry());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHouseCatForSaleThrowsExceptionWhenCatNameIsInvalid() {
        Cat cat = new Cat("Maca");
        Cat cat2 = new Cat("Pisa");

        house.addCat(cat);
        house.addCat(cat2);

        Cat soldCat = house.catForSale("Ivan");
    }

    @Test
    public void testHouseStatisticsReturnCorrectCatNames() {
        Cat cat = new Cat("Maca");
        Cat cat2 = new Cat("Pisa");

        house.addCat(cat);
        house.addCat(cat2);

        String expected = "The cat Maca, Pisa is in the house Valid name!";
        String actual = house.statistics();
        Assert.assertEquals(expected, actual);
    }
}
