package lecture02EncapsulationExcercise;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    private void setName(String name) {
        if(name.trim().length()==0){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setCost(double cost) {
        if(cost<0){
            throw new IllegalArgumentException("Cost cannot be negative");
        }
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }
}
