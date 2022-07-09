package cardealer.dto.customer;

import java.time.LocalDate;

public class ImportCustomerJsonDto {
//    {"name":"Natalie Poli", "birthDate":"1990-10-04T00:00:00", "isYoungDriver": false},

    private String name;
    private String birthDate;
    private boolean isYoungDriver;

    public ImportCustomerJsonDto() {
    }

    public ImportCustomerJsonDto(String name, String birthDate, boolean isYoungDriver) {
        this.name = name;
        this.birthDate = birthDate;
        this.isYoungDriver = isYoungDriver;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }
}
