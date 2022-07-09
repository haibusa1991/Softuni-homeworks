package L06DefiningClasses.E08FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class Relative {
    private String name = "";
    private String birthdate = "";
    private List<Relative> parents = new ArrayList<>();
    private final List<Relative> children = new ArrayList<>();

    public Relative(String data) {
        String[] tokens = data.split(" ");
        switch (tokens.length) {
            case 1:
                this.birthdate = tokens[0];
                break;
            case 2:
                this.name = String.join(" ", tokens);
                break;
            case 3:
                this.name = tokens[0] + " " + tokens[1];
                this.birthdate = tokens[2];
                break;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public void addChild(Relative child) {
        children.add(child);
    }

    public void addParent(Relative parent) {
        parents.add(parent);
    }

    public void printAll() {
        System.out.println(name + " " + birthdate);
        System.out.println("Parents:");
        parents.forEach(System.out::println);
        System.out.println("Children:");
        children.forEach(System.out::println);
    }


    public void mergeWith(Relative p) {
        if (this.name.equals("")) {
            this.name = p.name;
        }

        if (this.birthdate.equals("")) {
            this.birthdate = p.birthdate;
        }
        children.addAll(p.children);
        parents.addAll(p.parents);
    }

    public List<Relative> getParents() {
        return parents;
    }

    public void setParents(List<Relative> parents) {
        this.parents = parents;
    }

    public List<Relative> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return name + " " + birthdate;
    }

}
