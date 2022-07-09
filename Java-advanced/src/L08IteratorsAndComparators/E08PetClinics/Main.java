package L08IteratorsAndComparators.E08PetClinics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Pet> pets = new ArrayList<>();
    static List<Clinic> clinics = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            Pet pet;
            Clinic clinic;
            switch (tokens[0]) {
                case "Create":
                    if (tokens.length == 5) {
                        pets.add(new Pet(tokens[2], Integer.parseInt(tokens[3]), tokens[4]));
                        break;
                    }
                    try {
                        clinics.add(new Clinic(tokens[2], Integer.parseInt(tokens[3])));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case "Add":
                    pet = getPet(tokens[1]);
                    clinic = getClinic(tokens[2]);
                    assert clinic != null;
                    System.out.println(clinic.add(pet));
                    break;

                case "Release":
                    clinic = getClinic(tokens[1]);
                    assert clinic != null;
                    System.out.println(clinic.release());
                    break;

                case "HasEmptyRooms":
                    clinic = getClinic(tokens[1]);
                    assert clinic != null;
                    System.out.println(clinic.hasEmptyRooms());
                    break;

                case "Print":
                    clinic = getClinic(tokens[1]);
                    assert clinic != null;
                    if (tokens.length == 2) {
                        clinic.print();
                        break;
                    }
                    clinic.print(Integer.parseInt(tokens[2]));
                    break;
            }
        }

    }

    private static Pet getPet(String name) {
        for (Pet pet : pets) {
            if (pet.getName().equals(name)) {
                return pet;
            }
        }
        return null;
    }

    private static Clinic getClinic(String name) {
        for (Clinic clinic : clinics) {
            if (clinic.getName().equals(name)) {
                return clinic;
            }
        }
        return null;
    }

}
