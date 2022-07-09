package L02Relations.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "l02_plate_number")
public class PlateNumber {

    @Id
    @GeneratedValue
    @Column(name = "plate_id")
    private int id;

    private String number;

    public PlateNumber() {
    }

    public PlateNumber(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
