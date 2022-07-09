package automapper.entities.order;

import automapper.entities.game.Game;
import automapper.entities.user.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table (name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    @ManyToMany
    private Set<Game> contents;

    public Order() {
    }

    public Order(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Game> getContents() {
        return contents;
    }

    public void setContents(Set<Game> contents) {
        this.contents = contents;
    }
}
