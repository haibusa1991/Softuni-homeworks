package lecture05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E09PokemonDontGo {
    static List<Integer> pokemons = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        pokemons = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int finalSum = 0;
        while (!pokemons.isEmpty()) {
            int index = Integer.parseInt(scanner.nextLine());
            if (index < 0) {
                int removedIndexValue = pokemons.get(0);
                finalSum += removedIndexValue;
                pokemons.remove(0);
                updateValues(removedIndexValue);
                pokemons.add(0, pokemons.get(pokemons.size() - 1));
            } else if (index >= pokemons.size()) {
                int removedIndexValue = pokemons.get(pokemons.size() - 1);
                finalSum += removedIndexValue;
                pokemons.remove(pokemons.size() - 1);
                updateValues(removedIndexValue);
                pokemons.add(pokemons.size(), pokemons.get(0));
            } else {
                int removedIndexValue = pokemons.get(index);
                finalSum += removedIndexValue;
                pokemons.remove(index);
                updateValues(removedIndexValue);
            }
        }
        System.out.println(finalSum);
    }

    public static void updateValues(int value) {
        for (int i = 0; i < pokemons.size(); i++) {
            if (pokemons.get(i) <= value) {
                pokemons.set(i, pokemons.get(i) + value);
            } else {
                pokemons.set(i, pokemons.get(i) - value);
            }
        }
    }
}
