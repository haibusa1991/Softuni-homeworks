package lecture05polymorphism.E03WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();
        String input1 = scanner.nextLine();
        while (!input1.equals("End")) {
            String[] foodTokens = scanner.nextLine().split(" ");
            Food food;
            String foodType = foodTokens[0];
            int foodAmount = Integer.parseInt(foodTokens[1]);
            switch (foodType) {
                case "Vegetable":
                    food = new Vegetable(foodAmount);
                    break;
                case "Meat":
                    food = new Meat(foodAmount);
                    break;
                default:
                    throw new IllegalArgumentException("No such food - " + foodType);
            }

            String[] animalTokens = input1.split(" ");

            String animalType = animalTokens[0];
            String animalName = animalTokens[1];
            double animalWeight = Double.parseDouble(animalTokens[2]);
            String animalRegion = animalTokens[3];

            Animal animal;
            switch (animalType) {
                case "Mouse":
                    animal = new Mouse(animalName, animalWeight, animalRegion);
                    break;
                case "Cat":
                    String catBreed = animalTokens[4];
                    animal = new Cat(animalName, animalWeight, animalRegion, catBreed);
                    break;
                case "Tiger":
                    animal = new Tiger(animalName, animalWeight, animalRegion);
                    break;
                case "Zebra":
                    animal = new Zebra(animalName, animalWeight, animalRegion);
                    break;
                default:
                    throw new IllegalArgumentException("No such animal - " + animalType);
            }
            animals.add(animal);
            System.out.println(animal.makeSound());
            try {
                animal.eatFood(food);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            input1 = scanner.nextLine();
        }
        animals.forEach(System.out::println);
    }
}