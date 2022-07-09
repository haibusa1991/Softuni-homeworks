package exam.dto.shop;

import exam.dto.ImportNameDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class ShopImportDto {

    @XmlElement
    private String address;
    @XmlElement(name =  "employee-count")
    private int employeeCount;

    @XmlElement
    private BigDecimal income;

    @XmlElement
    private String name;

    @XmlElement(name = "shop-area")
    private int shopArea;

    @XmlElement(name = "town")
    private ImportNameDto shopTown;

    public String getAddress() {
        return address;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public String getName() {
        return name;
    }

    public int getShopArea() {
        return shopArea;
    }

    public ImportNameDto getShopTown() {
        return shopTown;
    }
}
