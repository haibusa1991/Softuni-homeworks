package cardealer.entities;

import javax.persistence.*;

@Entity
@Table(name = "sales")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(unique = true,referencedColumnName = "id")
    private Car car;

    @ManyToOne
    private Customer customer;

    @Column(name = "discount")
    @Enumerated(value = EnumType.STRING)
    private Discount discountPercentage;

    public Sale() {
    }

    public Sale(Car car, Customer customer, Discount discountPercentage) {
        this.car = car;
        this.customer = customer;
        this.discountPercentage = discountPercentage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Discount getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Discount discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
