package ExamPreparation.groomingSalon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GroomingSalon {
    private final int capacity;
    private final List<Pet> data = new ArrayList<>();

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
    }

    public void add(Pet pet) {
        if (data.size() < capacity) {
            data.add(pet);
        }
    }

    public boolean remove(String petName) {
        return data.removeIf(e -> e.getName().equals(petName));
    }

    public Pet getPet(String name, String owner) {
        Pet pet = null;
        try {
            pet = data.stream()
                    .filter(e -> e.getName().equals(name))
                    .filter(e -> e.getOwner().equals(owner))
                    .collect(Collectors.toList())
                    .get(0);
        } catch (Exception ignored) {
        }
        return pet;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder("The grooming salon has the following clients:").append(System.lineSeparator());
        for (Pet pet : data) {
            sb.append(pet.getName())
                    .append(" ")
                    .append(pet.getOwner())
                    .append(System.lineSeparator());
        }
        return sb.toString();
    }
}

