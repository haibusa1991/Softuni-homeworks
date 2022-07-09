package L02Relations.entities;

import L01vehicleHierarchy.entities.Truck;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "l02_drivers")
public class Driver {

    @Id
    @GeneratedValue
    @Column(name = "driver_id")
    private BigInteger id;

    @Column(name = "full_name")
    private String fullName;

    public Driver() {
    }

    @Column(name = "trucks")
    @ManyToMany(mappedBy = "drivers")
    private Set<Truck> trucks = new HashSet<>();

    public Driver(String name) {
        this.fullName = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
