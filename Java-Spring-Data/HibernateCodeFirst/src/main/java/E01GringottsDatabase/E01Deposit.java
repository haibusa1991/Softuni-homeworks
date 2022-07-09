package E01GringottsDatabase;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "e01_wizard_deposits")
public class E01Deposit {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "last_name", length = 60, nullable = false)
    private String lastName;

    @Column(length = 100)
    private String notes;

    @Column(nullable = false)
    private int age;

    @Column(length = 100)
    private String magicWandCreator;

    @Column(name = "magic_wand_size")
    private short magicWandSize;

    @Column(length = 20)
    private String depositGroup;

    @Column(nullable = false)
    private LocalDateTime depositStartDate;

    @Column(name = "deposit_amount")
    private BigDecimal depositAmount;

    @Column(name = "deposit_interest")
    private BigDecimal depositInterest;

    @Column(name = "deposit_charge")
    private BigDecimal depositCharge;

    @Column(name = "deposit_expiration_date")
    private LocalDateTime depositExpirationDate;

    @Column(name = "is_deposit_expited")
    private boolean depositExpired;

    public E01Deposit() {
    }

    public E01Deposit(String lastName, int age, LocalDateTime depositStartDate) {
        this.lastName = lastName;
        this.age = age;
        this.depositStartDate = depositStartDate;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMagicWandCreator() {
        return magicWandCreator;
    }

    public void setMagicWandCreator(String magicWandCreator) {
        this.magicWandCreator = magicWandCreator;
    }

    public short getMagicWandSize() {
        return magicWandSize;
    }

    public void setMagicWandSize(short magicWandSize) {
        this.magicWandSize = magicWandSize;
    }

    public String getDepositGroup() {
        return depositGroup;
    }

    public void setDepositGroup(String depositGroup) {
        this.depositGroup = depositGroup;
    }

    public LocalDateTime getDepositStartDate() {
        return depositStartDate;
    }

    public void setDepositStartDate(LocalDateTime depositStartDate) {
        this.depositStartDate = depositStartDate;
    }

    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    public BigDecimal getDepositInterest() {
        return depositInterest;
    }

    public void setDepositInterest(BigDecimal depositInterest) {
        this.depositInterest = depositInterest;
    }

    public BigDecimal getDepositCharge() {
        return depositCharge;
    }

    public void setDepositCharge(BigDecimal depositCharge) {
        this.depositCharge = depositCharge;
    }

    public LocalDateTime getDepositExpirationDate() {
        return depositExpirationDate;
    }

    public void setDepositExpirationDate(LocalDateTime depositExpirationDate) {
        this.depositExpirationDate = depositExpirationDate;
    }

    public boolean isDepositExpired() {
        return depositExpired;
    }

    public void setDepositExpired(boolean depositExpired) {
        this.depositExpired = depositExpired;
    }
}
