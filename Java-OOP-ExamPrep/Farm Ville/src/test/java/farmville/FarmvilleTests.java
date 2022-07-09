package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {
    private Farm farm;

    @Before
    public void setup(){
        farm=new Farm("Faaaarm",150);
    }

    @Test
    public void testFarmHappyPathFarmCreation(){
        farm=new Farm("LeFarm",150);
        Assert.assertNotNull(farm);
    }

    @Test
    public void testFarmGetNameReturnsName(){

        Assert.assertEquals("Faaaarm",farm.getName());
    }

    @Test (expected = NullPointerException.class)
    public void testFarmThrowsExceptionWhenNameIsNull(){
        farm=new Farm(null,150);
    }

    @Test (expected = NullPointerException.class)
    public void testFarmThrowsExceptionWhenNameIsEmpty(){
        farm=new Farm("",150);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testFarmThrowsExceptionWhenCapacityIsLessThanZero(){
        farm=new Farm("F",-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testFarmThrowsExceptionWhenCapacityIsFull(){
        Animal animal = new Animal("Cow", 1500);
        Animal animal2 = new Animal("Cow2", 1500);
        farm=new Farm("F",1);
        farm.add(animal);
        farm.add(animal2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testFarmThrowsExceptionWhenAddingDuplicateAnimal(){
        Animal animal = new Animal("Cow", 1500);
        Animal animal2 = new Animal("Cow", 1500);
        farm.add(animal);
        farm.add(animal2);
    }

    @Test
    public void testFarmAddAnimalAddsAnimal(){
        Animal animal = new Animal("Cow", 1500);
        Animal animal2 = new Animal("Cow2", 1500);
        farm.add(animal);
        farm.add(animal2);
        int expected =2;
        int actual = farm.getCount();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testFarmRemoveAnimalRemovesAnimal(){
        Animal animal = new Animal("Cow", 1500);
        Animal animal2 = new Animal("Cow2", 1500);

        farm.add(animal);
        farm.add(animal2);

        boolean result= farm.remove("Cow");
        Assert.assertTrue(result);

        result= farm.remove("Cowzzzzz");
        Assert.assertFalse(result);

    }
}
