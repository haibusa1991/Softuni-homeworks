package L02Relations.entities;

import L01vehicleHierarchy.entities.Plane;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "l02_companies")
public class Company {

    @Id
    @GeneratedValue
    @Column(name = "company_id")
    private BigInteger id;

    private String name;

    @OneToMany(targetEntity = Plane.class)
    private Set<Plane> planes = new HashSet<>();

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Plane> getPlanes() {
        return Collections.unmodifiableSet(this.planes);
    }

    public void setPlanes(Set<Plane> planes) {
        this.planes = planes;
    }

    public boolean addPlane(Plane plane) {
        return this.planes.add(plane);
    }
}
