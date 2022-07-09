package E02SalesDatabase.entites;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "e02_customers")
public class Customer {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    private String email;

    @Column(name = "credit_card_number", nullable = false)
    private String creditCardNumber;

    @OneToMany(targetEntity = Sale.class,mappedBy = "customer")
    private Set<Sale> sales = new HashSet<>();

    public Customer() {
    }

    public Customer(String name, String creditCardNumber) {
        this.name = name;
        this.creditCardNumber = creditCardNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Set<Sale> getSales() {
        return Collections.unmodifiableSet(this.sales);
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }

    public void addSale(Sale sale) {
        this.sales.add(sale);
    }
}
