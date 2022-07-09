package lecture01WorkingWithAbstraction.E05JediGalaxy;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Galaxy galaxy = new Galaxy(dimensions);
        Jedi jedi = new Jedi();
        Evil evil = new Evil();

        String command = scanner.nextLine();
        while (!command.equals("Let the Force be with you")) {
            int[] jediLocation = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evilLocation = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            jedi.setLocation(jediLocation);
            evil.setLocation(evilLocation);

            List<int[]> destroyedCells = evil.getDestroyedCells(galaxy.getDimensions());
            galaxy.destroyCells(destroyedCells);

            List<int[]> visitedCells = jedi.getVisitedCells(galaxy.getDimensions());

            jedi.addScore(galaxy.getSumOfCells(visitedCells));
            command = scanner.nextLine();
        }

        System.out.println(jedi.getScore());
    }
}
