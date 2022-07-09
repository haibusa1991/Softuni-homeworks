package L06DefiningClasses.E02CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private final String name;
    private final List<Employee> employees = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public double getAverageSalary() {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }
}

