package lecture03Inheritance.E06Animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String animal = scanner.nextLine();
        while (!animal.equals("Beast!")) {
            String[] tokens = scanner.nextLine().split(" ");
            Animal currentAnimal = null;
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String gender = tokens[2];
            try {
                switch (animal) {
                    case "Cat":
                        currentAnimal = new Cat(name, age, gender);
                        break;
                    case "Dog":
                        currentAnimal = new Dog(name, age, gender);
                        break;
                    case "Frog":
                        currentAnimal = new Frog(name, age, gender);
                        break;
                    case "Kitten":
                        currentAnimal = new Kitten(name, age);
                        break;
                    case "Tomcat":
                        currentAnimal = new Tomcat(name, age);
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            if (currentAnimal != null) {
                System.out.println(currentAnimal);
            }
            animal = scanner.nextLine();
        }
    }
}
