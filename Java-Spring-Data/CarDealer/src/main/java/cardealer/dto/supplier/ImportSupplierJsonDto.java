package cardealer.dto.supplier;

public class ImportSupplierJsonDto {
    private String name;
    private boolean isImporter;

    public ImportSupplierJsonDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }
}
