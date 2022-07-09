package E05BillsPaymentSystem.entites;

import javax.persistence.*;

@Entity(name = "e05_billing_details")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BillingDetailImpl implements BillingDetail {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String number;

    public BillingDetailImpl() {
    }

    public BillingDetailImpl(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}
