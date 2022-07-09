package E02SalesDatabase.entites;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "e02_store_locations")
public class StoreLocation {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "location_name", nullable = false)
    private String locationName;

    @OneToMany(targetEntity = Sale.class,mappedBy = "storeLocation")
    private Set<Sale> sales = new HashSet<>();

    public StoreLocation() {
    }

    public StoreLocation(String locationName) {
        this.locationName = locationName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Set<Sale> getSales() {
        return Collections.unmodifiableSet(this.sales);
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }

    public void addSale(Sale sale) {
        this.sales.add(sale);
    }
}
