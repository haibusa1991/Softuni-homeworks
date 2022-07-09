package lecture06.ME01CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String title;
    private List<Employee> employeeList = new ArrayList<>();

    public Department(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public double getAverageSalary() {
        return employeeList.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
    }

    public List<Employee> getEmployees() {
        return employeeList;
    }
}
