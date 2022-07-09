package L06DefiningClasses.E06PokemonTrainer;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Trainer> trainers = new LinkedHashMap<>();
        String input1 = scanner.nextLine();
        while (!input1.equals("Tournament")) {
            String[] tokens = input1.split(" ");
            String trainerName = tokens[0];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            trainers.putIfAbsent(trainerName, new Trainer(trainerName));
            Trainer currentTrainer = trainers.get(trainerName);
            currentTrainer.addPokemon(pokemonElement, pokemonHealth);
            trainers.put(trainerName, currentTrainer);
            input1 = scanner.nextLine();
        }

        String input2 = scanner.nextLine();
        while (!input2.equals("End")) {
            for (Trainer trainer : trainers.values()) {
                trainer.doElementCheck(input2);
            }
            input2 = scanner.nextLine();
        }
        trainers.values()
                .stream()
                .sorted(Comparator.comparingInt(Trainer::getNumBadges).reversed())
                .forEach(System.out::println);
    }
}
