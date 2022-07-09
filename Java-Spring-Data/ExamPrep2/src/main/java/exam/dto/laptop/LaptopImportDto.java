package exam.dto.laptop;

import exam.dto.ImportNameDto;
import exam.model.Warranty;

import java.math.BigDecimal;

public class LaptopImportDto {
    private String macAddress;
    private double cpuSpeed;
    private int ram;
    private int storage;
    private String description;
    private BigDecimal price;
    private Warranty warrantyType;
    private ImportNameDto shop;

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

    public ImportNameDto getShop() {
        return shop;
    }

    public void setShop(ImportNameDto shop) {
        this.shop = shop;
    }

    public Warranty getWarrantyType() {
        return warrantyType;
    }

    public void setWarrantyType(Warranty warrantyType) {
        this.warrantyType = warrantyType;
    }
}
