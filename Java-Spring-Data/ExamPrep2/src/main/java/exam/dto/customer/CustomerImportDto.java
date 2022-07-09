package exam.dto.customer;

import exam.dto.ImportNameDto;

public class CustomerImportDto {

    private String firstName;
    private String lastName;
    private String email;
    private String registeredOn;
    private ImportNameDto town;

    public CustomerImportDto() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getRegisteredOn() {
        return registeredOn;
    }

    public ImportNameDto getTown() {
        return town;
    }
}
