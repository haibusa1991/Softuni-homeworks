package exam.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "laptops")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Length(min = 8)
    @Column(name = "mac_address",unique = true)
    @NotNull
    private String macAddress;

    @Positive
    @NotNull
    private double cpuSpeed;

    @Min(8)
    @Max(128)
    @NotNull
    private int ram;

    @Min(128)
    @Max(1024)
    @NotNull
    private int storage;

    @Length(min = 10)
    @Column(columnDefinition = "TEXT")
    private String description;

    @Positive
    @NotNull
    private BigDecimal price;

    @Enumerated
    @NotNull
    private Warranty warranty;

    @ManyToOne
    private Shop shop;

    public Laptop() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public double getCpuSpeed() {
        return cpuSpeed;
    }

    public void setCpuSpeed(double cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Warranty getWarranty() {
        return warranty;
    }

    public void setWarranty(Warranty warranty) {
        this.warranty = warranty;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shops) {
        this.shop = shops;
    }
}
