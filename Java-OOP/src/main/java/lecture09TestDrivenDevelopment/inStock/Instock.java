package lecture09TestDrivenDevelopment.inStock;

import jdk.jshell.spi.ExecutionControl;

import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {
    Map<String, Product> stock = new LinkedHashMap<>();


    @Override
    public int getCount() {
        return this.stock.size();
    }

    @Override
    public boolean contains(Product product) {
        return this.stock.containsValue(product);
    }

    @Override
    public void add(Product product) {
        this.stock.putIfAbsent(product.getLabel(), product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        try {
            Product target = this.stock.get(product);
            target.quantity = quantity;
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Product find(int index) {
        List<Product> products = new ArrayList<>(this.stock.values());
        return products.get(index);
    }

    @Override
    public Product findByLabel(String label) {
        if (this.stock.get(label) == null) {
            throw new IllegalArgumentException();
        }
        return this.stock.get(label);
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if (count < 0 || count >= this.stock.size()) {
            return new ArrayList<>();
        }
        return this.stock.values().stream()
                .sorted(Comparator.comparing(Product::getLabel))
                .limit(count)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        return this.stock.values().stream()
                .filter(e -> e.getPrice() > lo && e.getPrice() <= hi)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        return this.stock.values().stream()
                .filter(e -> e.getPrice() == price)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if (count >= this.stock.size()) {
            throw new IllegalArgumentException();
        }

        return this.stock.values().stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(count)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return this.stock.values().stream()
                .filter(e -> e.getQuantity() == quantity)
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Product> iterator() {
        return this.stock.values().iterator();
    }
}
