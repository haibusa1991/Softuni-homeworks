package L06DefiningClasses.E06PokemonTrainer;

public class Pokemon {
    private final String element;
    private int health;
    private boolean isDead = false;

    public Pokemon(String element, int health) {
        this.element = element;
        this.health = health;
    }

    public String getElement() {
        return element;
    }

    public void takeDamage() {
        health -= 10;
        if (health <= 0) {
            isDead = true;
        }
    }

    public boolean isDead() {
        return isDead;
    }
}
