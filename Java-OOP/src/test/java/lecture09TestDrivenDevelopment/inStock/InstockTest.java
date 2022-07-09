package lecture09TestDrivenDevelopment.inStock;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertNotNull;

public class InstockTest {
    private final String NON_EXISTING_PRODUCT_LABEL = "test_no_such_product_is_added";
    private Instock stock;
    private final Product[] products = new Product[]{
            new ProductBuilder().setLabel("sweets").setPrice(2.99).setQuantity(150).createProduct(),
            new ProductBuilder().setLabel("not sweets").setPrice(2.99).setQuantity(150).createProduct(),
            new ProductBuilder().setLabel("cheese").setPrice(9.99).setQuantity(50).createProduct(),
            new ProductBuilder().setLabel("wine").setPrice(6.33).setQuantity(2).createProduct(),
            new ProductBuilder().setLabel("ham").setPrice(13.9).setQuantity(25).createProduct(),
    };


    @Before
    public void setUp() {
        this.stock = new Instock();
        addAllProducts();
    }

    @Test
    public void testAddAddsProductToStock() {
        for (Product product : products) {
            Assert.assertTrue(stock.contains(product));
        }
    }

    @Test
    public void testCountReturnsCountOfAddedProducts() {
        Assert.assertEquals(products.length, stock.getCount());
    }

    @Test
    public void testFindReturnsNthProduct() {
        Product expected = products[2];
        Product actual = stock.find(2);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindThrowsExceptionIndexLess() {
        stock.find(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindThrowsExceptionIndexGreater() {
        stock.find(products.length);
    }

    @Test
    public void testChangeQuantity() {
        Product product = products[2];
        stock.changeQuantity(product.label, 150);
        product.setQuantity(150);
        Product expected = product;
        Product actual = stock.findByLabel(product.getLabel());
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityThrowsExceptionNoMatch() {
        try {
            stock.changeQuantity(NON_EXISTING_PRODUCT_LABEL, 30);
        } catch (NullPointerException ignored) {
        }
    }

    @Test
    public void testFindByLabelReturnsProductByLabel() {
        Product expected = products[2];
        Product actual = stock.findByLabel(expected.getLabel());
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelThrowsExceptionNoMatch() {
        stock.findByLabel(NON_EXISTING_PRODUCT_LABEL);
    }

    @Test
    public void testFindFirstByAlphabeticalOrderReturnsFirstNProducts() {
        int productsCount = 2;
        List<Product> expected = new ArrayList<>(Arrays.asList(products))
                .stream()
                .sorted(Comparator.comparing(Product::getLabel))
                .limit(productsCount)
                .collect(Collectors.toList());

        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(productsCount);

        assertNotNull(iterable);
        List<Product> actual = getAsList(iterable);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindFirstByAlphabeticalOrderReturnsEmptyCollectionIndexLess() {
        List<Product> expected = new ArrayList<>();

        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(-1);
        List<Product> actual = getAsList(iterable);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindFirstByAlphabeticalOrderReturnsEmptyCollectionIndexGreater() {
        List<Product> expected = new ArrayList<>();

        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(products.length);
        List<Product> actual = getAsList(iterable);

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testFindAllInPriceRangeReturnsAllProductsInRange() {
        double lowerBound = 2.99;
        double upperBound = 9.99;

        List<Product> expected = Arrays.stream(products)
                .filter(e -> e.price > lowerBound && e.price <= upperBound)
                .collect(Collectors.toList());

        Iterable<Product> iterable = stock.findAllInRange(lowerBound, upperBound);

        Assert.assertNotNull(iterable);
        List<Product> actual = getAsList(iterable);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindAllInPriceRangeNoMatchesInRangeReturnsEmptyCollection() {
        double lowerBound = 1000;
        double upperBound = 2000;

        List<Product> expected = new ArrayList<>();

        Iterable<Product> iterable = stock.findAllInRange(lowerBound, upperBound);

        Assert.assertNotNull(iterable);
        List<Product> actual = getAsList(iterable);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindAllByPriceReturnsCollectionOfProductsWithPrice() {
        double price = 2.99;

        List<Product> expected = Arrays.stream(products)
                .filter(e -> e.price == price)
                .collect(Collectors.toList());

        Iterable<Product> iterable = stock.findAllByPrice(price);

        Assert.assertNotNull(iterable);
        List<Product> actual = getAsList(iterable);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindAllByPriceReturnsEmptyCollectionNoMatches() {
        double price = 10002.99;

        List<Product> expected = new ArrayList<>();

        Iterable<Product> iterable = stock.findAllByPrice(price);

        Assert.assertNotNull(iterable);
        List<Product> actual = getAsList(iterable);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindFirstMostExpensiveProductsReturnsCollectionOfFirstNMostExpensiveProducts() {
        int productsCount = 2;

        List<Product> expected = Arrays.stream(products)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(productsCount)
                .collect(Collectors.toList());

        Iterable<Product> iterable = stock.findFirstMostExpensiveProducts(productsCount);

        Assert.assertNotNull(iterable);
        List<Product> actual = getAsList(iterable);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFirstMostExpensiveProductsThrowsExceptionCountGreater() {
        stock.findFirstMostExpensiveProducts(products.length);
    }

    @Test
    public void testFindAllByQuantityReturnsCollectionOfProductsWithExactQuantity() {
        int targetQuantity = products[0].getQuantity();

        List<Product> expected = Arrays.stream(products)
                .filter(e -> e.getQuantity() == targetQuantity)
                .collect(Collectors.toList());

        Iterable<Product> iterable = stock.findAllByQuantity(targetQuantity);

        Assert.assertNotNull(iterable);
        List<Product> actual = getAsList(iterable);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindAllByQuantityReturnsEmptyCollectionNoMatches() {
        int targetQuantity = Integer.MAX_VALUE;

        List<Product> expected = new ArrayList<>();

        Iterable<Product> iterable = stock.findAllByQuantity(targetQuantity);

        Assert.assertNotNull(iterable);
        List<Product> actual = getAsList(iterable);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetIteratorReturnsAllProductsInStock(){
        List<Product> expected = Arrays.asList(products);

        Iterator<Product> iterator = stock.iterator();

        Assert.assertNotNull(iterator);

        List<Product> actual = new ArrayList<>();

        while (iterator.hasNext()){
            actual.add(iterator.next());
        }

        Assert.assertEquals(expected, actual);
    }

    private <T> List<T> getAsList(Iterable<T> iterable) {
        List<T> list = new ArrayList<>();
        for (T t : iterable) {
            list.add(t);
        }
        return list;
    }

    private void addAllProducts() {
        for (Product product : products) {
            stock.add(product);
        }
    }
}