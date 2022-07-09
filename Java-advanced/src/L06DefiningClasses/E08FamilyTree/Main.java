package L06DefiningClasses.E08FamilyTree;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Relative> people = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String target = scanner.nextLine();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split(" - ");
            switch (tokens.length) {
                case 1:
                    String[] fullInfo = input.split(" ");
                    String name = fullInfo[0] + " " + fullInfo[1];
                    String birthdate = fullInfo[2];
                    Relative personPart1 = getByName(name);
                    Relative personPart2 = getByBirthdate(birthdate);
                    if (personPart1 == null || personPart2 == null) {
                        Relative person = getByName(name);
                        if (person != null) {
                            person.setBirthdate(birthdate);
                        } else {
                            person = getByBirthdate(birthdate);
                            person.setName(name);
                        }
                    } else {
                        personPart1.mergeWith(personPart2);
                        for(Relative r : people){
                            if (r.getChildren().contains(personPart2)){
                                r.getChildren().set(r.getChildren().indexOf(personPart2),personPart1);
                            }

                            if (r.getParents().contains(personPart2)){
                                r.getParents().set(r.getParents().indexOf(personPart2),personPart1);
                            }
                        }
                        people.set(people.indexOf(personPart2), personPart1);
                        people.remove(personPart1);
                    }
                    break;
                case 2:
                    String parentData = tokens[0];
                    String childData = tokens[1];
                    Relative parent = getRelative(parentData);
                    Relative child = getRelative(childData);

                    if (parent == null) {
                        parent = new Relative(parentData);
                        people.add(parent);
                    }

                    if (child == null) {
                        child = new Relative(childData);
                        people.add(child);
                    }

                    parent.addChild(child);
                    child.addParent(parent);
                    break;
            }
            input = scanner.nextLine();
        }

        Relative targetPerson = getRelative(target);
        targetPerson.printAll();

    }

    private static Relative getByName(String name) {
        Relative relative = null;
        for (Relative r : people) {
            if (r.getName().equals(name)) {
                relative = r;
            }
        }
        return relative;
    }

    private static Relative getByBirthdate(String birthdate) {

        Relative relative = null;
        for (Relative r : people) {
            if (r.getBirthdate().equals(birthdate)) {
                relative = r;
            }
        }
        return relative;
    }

    private static Relative getRelative(String input) {
        if (input.contains("/")) {
            return getByBirthdate(input);
        }
        return getByName(input);
    }
}