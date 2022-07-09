package cardealer.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "uses_imported_parts")
    private boolean usesImportedParts;

    @OneToMany(targetEntity = Part.class, mappedBy = "supplier")
    private Set<Part> suppliedParts;

    public Supplier() {
        this.suppliedParts = new HashSet<>();
    }

    public Supplier(String name, boolean usesImportedParts, Set<Part> suppliedParts) {
        this();
        this.name = name;
        this.usesImportedParts = usesImportedParts;
        this.suppliedParts = suppliedParts;
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

    public boolean isUsesImportedParts() {
        return usesImportedParts;
    }

    public void setUsesImportedParts(boolean usesImportedParts) {
        this.usesImportedParts = usesImportedParts;
    }

    public Set<Part> getSuppliedParts() {
        return suppliedParts;
    }

    public void setSuppliedParts(Set<Part> suppliedParts) {
        this.suppliedParts = suppliedParts;
    }
}
