package E04HospitalDatabase.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "e04_medication")
public class Medicament {
    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    public Medicament() {
    }

    public Medicament(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
