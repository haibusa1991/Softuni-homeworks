package lecture06.ME01CompanyRoster;

public class Employee {

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email = "n/a";
    private int age = -1;

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public Employee(String name, double salary, String position, String department, String optionalInfo) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        if (optionalInfo.contains("@")) {
            email = optionalInfo;
        } else {
            age = Integer.parseInt(optionalInfo);
        }
    }

    public Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", name, salary, email, age);
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}
