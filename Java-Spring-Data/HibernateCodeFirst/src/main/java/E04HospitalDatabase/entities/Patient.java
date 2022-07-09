package E04HospitalDatabase.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "e04_patients")
public class Patient {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String address;

    private String email;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    private String picture;

    @Column(name = "isInsured", nullable = false)
    private boolean insured;

    @OneToMany(targetEntity = Visitation.class)
    private Set<Visitation> visitations = new HashSet<>();

    @OneToMany(targetEntity = Medicament.class)
    private Set<Medicament> usedMedicament = new HashSet<>();

    @OneToMany(targetEntity = Diagnose.class)
    private Set<Diagnose> diagnoses = new HashSet<>();

    public boolean addVisitation(Visitation visitation) {
        return this.visitations.add(visitation);
    }

    public boolean removeVisitation(Visitation visitation) {
        return this.visitations.remove(visitation);
    }

    public boolean addMedicament(Medicament medicament) {
        return this.usedMedicament.add(medicament);
    }

    public boolean removeMedicament(Medicament medicament) {
        return this.usedMedicament.remove(medicament);
    }

    public boolean addDiagnose(Diagnose diagnose) {
        return this.diagnoses.add(diagnose);
    }

    public boolean removeDiagnose(Diagnose diagnose) {
        return this.diagnoses.remove(diagnose);
    }


    public Patient() {
    }

    public Patient(String firstName, String lastName, LocalDate birthDate, boolean insured, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.insured = insured;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public boolean isInsured() {
        return insured;
    }

    public void setInsured(boolean insured) {
        this.insured = insured;
    }

    public Set<Visitation> getVisitations() {
        return visitations;
    }

    public void setVisitations(Set<Visitation> visitations) {
        this.visitations = visitations;
    }

    public Set<Medicament> getUsedMedicament() {
        return usedMedicament;
    }

    public void setUsedMedicament(Set<Medicament> usedMedicament) {
        this.usedMedicament = usedMedicament;
    }

    public Set<Diagnose> getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(Set<Diagnose> diagnoses) {
        this.diagnoses = diagnoses;
    }
}
