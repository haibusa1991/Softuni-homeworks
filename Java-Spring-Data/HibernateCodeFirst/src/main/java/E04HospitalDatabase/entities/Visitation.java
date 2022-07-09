package E04HospitalDatabase.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "e04_visitations")
public class Visitation {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "visitation_date",nullable = false)
    private LocalDateTime visitationDate;

    private String comment;

    public Visitation() {
    }

    public Visitation(LocalDateTime visitationDate) {
        this.visitationDate = visitationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getVisitationDate() {
        return visitationDate;
    }

    public void setVisitationDate(LocalDateTime visitationDate) {
        this.visitationDate = visitationDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
