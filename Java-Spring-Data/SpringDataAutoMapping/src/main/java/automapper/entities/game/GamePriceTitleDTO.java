package automapper.entities.game;

import java.math.BigDecimal;
import java.util.Objects;

public class GamePriceTitleDTO extends GameTitleDTO {
    private BigDecimal price;

    public GamePriceTitleDTO(String title, BigDecimal price) {
        super(title);
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", super.getTitle(), price);
    }


}

