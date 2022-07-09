package cardealer.dto.supplier;

import com.google.gson.annotations.SerializedName;

public class ExportSupplierSimpleJsonDto {
    @SerializedName("Id")
    private int id;

    @SerializedName("Name")
    private String name;

    private int partsCount;

    public ExportSupplierSimpleJsonDto() {
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

    public int getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(int partsCount) {
        this.partsCount = partsCount;
    }
}
