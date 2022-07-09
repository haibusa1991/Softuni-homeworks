package E05BillsPaymentSystem.entites;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "e05_users")
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    private String email;

    @Column(nullable = false)
    private String password;

    @OneToMany(targetEntity = BillingDetailImpl.class)
    private Set<BillingDetail> billingDetails = new HashSet<>();

    public User() {
    }

    public User(String firstName, String lastName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public boolean addBillingDetail(BillingDetail billingDetail) {
        return this.billingDetails.add(billingDetail);
    }

    public boolean removeBillingDetail(BillingDetail billingDetail) {
        return this.billingDetails.remove(billingDetail);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<BillingDetail> getBillingDetails() {
        return billingDetails;
    }

    public void setBillingDetails(Set<BillingDetail> billingDetails) {
        this.billingDetails = billingDetails;
    }
}
