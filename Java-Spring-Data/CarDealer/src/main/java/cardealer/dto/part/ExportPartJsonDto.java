package cardealer.dto.part;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class ExportPartJsonDto {
    @SerializedName("Name")
    private String name;

    @SerializedName("Price")
    private BigDecimal price;

    public ExportPartJsonDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExportPartJsonDto that = (ExportPartJsonDto) o;

        if (!name.equals(that.name)) return false;
        return price.equals(that.price);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + price.hashCode();
        return result;
    }
}
