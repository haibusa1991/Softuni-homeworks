package lecture06.L04Songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numSongs = Integer.parseInt(scanner.nextLine());

        List<Song> playlist = new ArrayList<>();

        for (int i = 0; i < numSongs; i++) {
            String[] input = scanner.nextLine().split("_");
            playlist.add(new Song(input[0], input[1]));
        }

        String type = scanner.nextLine();
        if (type.equals("all")) {
            for (Song song : playlist) {
                System.out.println(song);
            }
        } else {
            List<Song> output = playlist.stream()
                    .filter(e -> e.getType().equals(type))
                    .collect(Collectors.toList());
            for (Song song : output) {
                System.out.println(song);
            }
        }
    }
}

