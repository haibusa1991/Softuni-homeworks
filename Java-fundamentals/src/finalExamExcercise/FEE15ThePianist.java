package finalExamExcercise;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//https://judge.softuni.bg/Contests/Practice/Index/2525#2
public class FEE15ThePianist {
    //    piece, composer|key
    static Map<String, String> pieces = new HashMap<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            addPiece("Add|" + scanner.nextLine(), true);
        }
        String input = scanner.nextLine();
        while (!input.equals("Stop")) {
            if (input.contains("Add")) {
                addPiece(input, false);
            } else if (input.contains("Remove")) {
                removePiece(input);
            } else {
                changeKey(input);
            }
            input = scanner.nextLine();
        }
        pieces.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry<String, String>::getKey).thenComparing(e -> getComposer(e.getKey())))
                .forEach(e -> System.out.printf("%s -> Composer: %s, Key: %s%n", e.getKey(), getComposer(e.getKey()), getPieceKey(e.getKey())));
    }

    private static String getPieceKey(String input) {
        return pieces.get(input).split("\\|")[1];
    }

    private static String getComposer(String input) {
        return pieces.get(input).split("\\|")[0];
    }

    private static void changeKey(String input) {
        String[] data = input.split("\\|");
        String piece = data[1];
        String key = data[2];
        if (pieces.containsKey(piece)) {
            pieces.put(piece, getComposer(piece) + "|" + key);
            System.out.printf("Changed the key of %s to %s!%n", piece, key);
        } else {
            System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
        }
    }

    private static void removePiece(String input) {
        String[] data = input.split("\\|");
        String piece = data[1];
        if (pieces.containsKey(piece)) {
            pieces.remove(piece);
            System.out.printf("Successfully removed %s!%n", piece);
        } else {
            System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
        }
    }

    private static void addPiece(String input, boolean isSilent) {
        String[] data = input.split("\\|");
        String piece = data[1];
        String composer = data[2];
        String key = data[3];
        if (pieces.containsKey(piece)) {
            System.out.printf("%s is already in the collection!%n", piece);
        } else {
            pieces.put(piece, composer + "|" + key);
            if (!isSilent) {
                System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, key);
            }
        }
    }
}
