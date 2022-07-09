package lecture03;

import java.util.Scanner;

public class L03AnimalType {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String animalInput = scanner.nextLine();
        String animalOutput = "";

        switch (animalInput) {
            case "dog":
                animalOutput = "mammal";
                break;
            case "crocodile":
            case "tortoise":
            case "snake":
                animalOutput = "reptile";
                break;
            default:
                animalOutput = "unknown";
                break;
        }
        System.out.println(animalOutput);
    }
}
