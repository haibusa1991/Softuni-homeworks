package E05BillsPaymentSystem.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "e05_bank_accounts")
public class BankAccount extends BillingDetailImpl{

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "bank_name", nullable = false)
    private String bankName;

    @Column(name = "swift_code",nullable = false)
    private String swiftCode;

    public BankAccount() {
    }

    public BankAccount(String number, String bankName, String swiftCode) {
        super(number);
        this.bankName = bankName;
        this.swiftCode = swiftCode;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }
}
