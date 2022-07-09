package L06DefiningClasses.E02CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Department> departments = new HashMap<>();
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String departmentTitle = tokens[3];

            departments.putIfAbsent(departmentTitle, new Department(departmentTitle));
            Department currentDepartment = departments.get(departmentTitle);
            switch (tokens.length) {
                case 4:
                    currentDepartment.addEmployee(new Employee(name, salary, position, departmentTitle));
                    break;
                case 5:
                    try {
                        currentDepartment.addEmployee(new Employee(name, salary, position, departmentTitle, Integer.parseInt(tokens[4])));
                    } catch (Exception e) {
                        currentDepartment.addEmployee(new Employee(name, salary, position, departmentTitle, tokens[4]));
                    }
                    break;
                case 6:
                    currentDepartment.addEmployee(new Employee(name, salary, position, departmentTitle, tokens[4], Integer.parseInt(tokens[5])));
                    break;
            }
            departments.put(departmentTitle, currentDepartment);
        }
        double maxAverageSalary = 0;
        String bestDepartment = "";
        for (Department d : departments.values()) {
            double averageSalary = d.getAverageSalary();
            if (averageSalary > maxAverageSalary) {
                maxAverageSalary = averageSalary;
                bestDepartment = d.getName();
            }
        }


        System.out.printf("Highest Average Salary: %s\n", bestDepartment);
        departments.get(bestDepartment)
                .getEmployees()
                .stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(System.out::println);

    }
}
