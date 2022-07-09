package E05BillsPaymentSystem.entites;

import javax.persistence.*;
import java.time.Month;
import java.time.Year;

@Entity(name = "e05_credit_cards")
public class CreditCard extends BillingDetailImpl{

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private CreditCardType type;

    @Column(name = "expiration_month",nullable = false)
    private Month expirationMonth;

    @Column(name = "expiration_year",nullable = false)
    private Year expirationYear;

    public CreditCard() {
    }

    public CreditCard(String number, CreditCardType type, Month expirationMonth, Year expirationYear) {
        super(number);
        this.type = type;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public CreditCardType getType() {
        return type;
    }

    public void setType(CreditCardType type) {
        this.type = type;
    }

    public Month getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(Month expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public Year getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(Year expirationYear) {
        this.expirationYear = expirationYear;
    }
}
