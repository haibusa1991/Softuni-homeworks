package ExamPreparation.cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cafe {
    private final String name;
    private final int capacity;
    private final List<Employee> employees = new ArrayList<>();

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public void addEmployee(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        boolean hasFound = employees.stream().anyMatch(e -> e.getName().equals(name));
        if (hasFound) {
            employees.removeIf(e -> e.getName().equals(name));
        }
        return hasFound;
    }

    public Employee getOldestEmployee() {
        return employees.stream().max(Comparator.comparingInt(Employee::getAge)).get();
    }

    public Employee getEmployee(String name) {
        return employees.stream().filter(e -> e.getName().equals(name)).collect(Collectors.toList()).get(0);
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Employees working at Cafe ")
                .append(name).append(":")
                .append(System.lineSeparator());
        employees.forEach(e->stringBuilder.append(e).append(System.lineSeparator()));
        return stringBuilder.toString();
    }
}
