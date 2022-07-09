package L06DefiningClasses.E06PokemonTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private final String name;
    private int numBadges;
    private final List<Pokemon> pokemonList = new ArrayList<>();

    public Trainer(String name) {
        this.name = name;
    }

    public void doElementCheck(String element) {
        int numPokemon = (int) pokemonList.stream()
                .filter(e -> e.getElement().equals(element))
                .count();
        if (numPokemon > 0) {
            numBadges++;
        } else {
            pokemonList.forEach(Pokemon::takeDamage);
            pokemonList.removeIf(Pokemon::isDead);
        }
    }

    public void addPokemon(String element, int health) {
        pokemonList.add(new Pokemon(element, health));
    }

    public int getNumBadges() {
        return numBadges;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", name, numBadges, pokemonList.size());
    }
}
