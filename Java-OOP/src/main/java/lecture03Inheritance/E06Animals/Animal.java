package lecture03Inheritance.E06Animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        if (name.trim().length() == 0
                || age < 0
                || gender.trim().length() == 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String produceSound() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName()).append(System.lineSeparator());
        stringBuilder.append(this.name).append(" ").append(this.age).append(" ").append(this.gender).append(System.lineSeparator());
        stringBuilder.append(this.produceSound());
        return stringBuilder.toString();
    }
}
