package lecture02EncapsulationExcercise;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = new LinkedHashMap<>();
        String[] peopleData = scanner.nextLine().split(";");
        for (String person : peopleData) {
            try {
                String name = person.split("=")[0];
                int money = Integer.parseInt(person.split("=")[1]);
                people.put(name, new Person(name, money));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        Map<String, Product> products = new LinkedHashMap<>();
        String[] productData = scanner.nextLine().split(";");
        for (String product : productData) {
            try {
                String name = product.split("=")[0];
                int cost = Integer.parseInt(product.split("=")[1]);
                products.put(name, new Product(name, cost));
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            Person person = people.get(command.split(" ")[0]);
            Product product = products.get(command.split(" ")[1]);
            try {
                person.buyProduct(product);
                System.out.println(person.getName() + " bought " + product.getName());
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return;
            }
            command = scanner.nextLine();
        }

        people.values().forEach(System.out::println);

    }
}
