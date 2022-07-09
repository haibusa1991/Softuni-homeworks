package automapper.entities.game;

import automapper.annotations.Capitalized;
import automapper.annotations.Http;
import automapper.annotations.YoutubeVideo;
import automapper.entities.user.User;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Length(min = 3, max = 100)
    @Capitalized
    @Column(nullable = false)
    private String title;

    @YoutubeVideo
    private String trailerYoutubeId;

    @Http
    private String imageThumbnail;

    @Positive
    //size in GB
    private double size;

    @Positive
    @Column(nullable = false)
    private BigDecimal price;

    @Length(min = 20)
    private String description;

    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    public Game() {
    }

    public Game(String title, BigDecimal price, LocalDate releaseDate) {
        this.title = title;
        this.price = price;
        this.releaseDate = releaseDate;
    }

    public Game(String title,
                String trailerYoutubeId,
                String imageThumbnail,
                double size,
                BigDecimal price,
                String description,
                LocalDate releaseDate) {
        this.title = title;
        this.trailerYoutubeId = trailerYoutubeId;
        this.imageThumbnail = imageThumbnail;
        this.size = size;
        this.price = price;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTrailerYoutubeId() {
        return trailerYoutubeId;
    }

    public void setTrailerYoutubeId(String trailerYoutubeId) {
        this.trailerYoutubeId = trailerYoutubeId;
    }

    public String getImageThumbnail() {
        return imageThumbnail;
    }

    public void setImageThumbnail(String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (id != game.id) return false;
        return title.equals(game.title);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + title.hashCode();
        return result;
    }
}
