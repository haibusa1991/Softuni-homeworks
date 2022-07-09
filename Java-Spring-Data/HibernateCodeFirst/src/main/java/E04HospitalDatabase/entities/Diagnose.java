package E04HospitalDatabase.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "e04_diagnoses")
public class Diagnose {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String name;

    private String notes;

    public Diagnose() {
    }

    public Diagnose(String name) {
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
