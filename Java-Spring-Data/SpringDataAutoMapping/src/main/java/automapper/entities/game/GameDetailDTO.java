package automapper.entities.game;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GameDetailDTO extends GamePriceTitleDTO {
    private String description;
    private LocalDate releaseDate;

    private GameDetailDTO(String title, BigDecimal price) {
        super(title, price);
    }

    public GameDetailDTO(String title, BigDecimal price, String description, LocalDate releaseDate) {
        super(title, price);
        this.description = description;
        this.releaseDate = releaseDate;
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
    public String toString() {
        return String.format("""
                        Title: %s
                        Price: %.2f
                        Description: %s
                        Release date: %s""",
                super.getTitle(),
                super.getPrice(),
                this.description,
                this.releaseDate);
    }
}
