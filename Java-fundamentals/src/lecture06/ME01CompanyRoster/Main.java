package lecture06.ME01CompanyRoster;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            switch (input.length) {
                case 4:
                    employees.add(new Employee(input[0],
                            Double.parseDouble(input[1]),
                            input[2],
                            input[3]));
                    break;
                case 5:
                    employees.add(new Employee(input[0],
                            Double.parseDouble(input[1]),
                            input[2],
                            input[3],
                            input[4]));
                    break;
                case 6:
                    employees.add(new Employee(input[0],
                            Double.parseDouble(input[1]),
                            input[2],
                            input[3],
                            input[4],
                            Integer.parseInt(input[5])));
                    break;
            }
        }

        List<Department> departments = new ArrayList<>();
        for (Employee employee : employees) {
            String currentDepartment = employee.getDepartment();
            boolean isDepartmentExisting = departments.stream().anyMatch(d -> d.getTitle().equals(currentDepartment));
            if (!isDepartmentExisting) {
                departments.add(new Department(currentDepartment));
                departments.get(departments.size() - 1).addEmployee(employee);
            } else {
                departments.stream()
                        .filter(d -> d.getTitle().equals(currentDepartment))
                        .collect(Collectors.toList())
                        .get(0)
                        .addEmployee(employee);
            }
        }

        double maxSalary = departments.stream()
                .mapToDouble(Department::getAverageSalary)
                .max()
                .orElse(0);

        List<Employee> bestEmployees = departments.stream()
                .filter(d -> d.getAverageSalary() == maxSalary)
                .collect(Collectors.toList())
                .get(0)
                .getEmployees();

        String bestDepartment = bestEmployees.get(0).getDepartment();
        System.out.printf("Highest Average Salary: %s%n", bestDepartment);
        bestEmployees.sort(Comparator.comparing(Employee::getSalary));
        Collections.reverse(bestEmployees);
        bestEmployees.forEach(System.out::println);
    }
}
