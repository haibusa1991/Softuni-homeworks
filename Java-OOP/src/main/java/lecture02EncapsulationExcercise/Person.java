package lecture02EncapsulationExcercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product p) {
        if (p.getCost() > this.money) {
            throw new IllegalStateException(this.name + " can't afford " + p.getName());
        }
        this.money -= p.getCost();
        this.products.add(p);

    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (products.isEmpty()) {
            return this.name + " - Nothing bought";
        }

        sb.append(this.name).append(" - ");
        sb.append(products.stream().map(Product::getName).collect(Collectors.joining(", ")));
        return sb.toString();
    }
}
