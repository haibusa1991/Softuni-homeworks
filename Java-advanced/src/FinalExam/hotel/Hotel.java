package FinalExam.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private String name;
    private int capacity;
    private List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        roster = new ArrayList<>();
    }

    public void add(Person person) {
        if (roster.size() < capacity) {
            roster.add(person);
        }
    }

    public boolean remove(String name) {
        return roster.removeIf(e -> e.getName().equals(name));
    }

    public Person getPerson(String name, String hometown) {
        return roster.stream()
                .filter(e -> e.getName().equals(name) && e.getHometown().equals(hometown))
                .findFirst()
                .orElse(null);
    }

    public int getCount() {
        return roster.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The people in the hotel %s are:%n", this.name));
        for (Person person : roster) {
            sb.append(person);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

}
