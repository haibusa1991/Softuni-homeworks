package JsonEx.entities.category;

public class CategoryRegistrationDto {
    private String name;

    public CategoryRegistrationDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
