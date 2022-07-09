package lecture01WorkingWithAbstraction.L02PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tokens = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Rectangle rec = new Rectangle(new Point(tokens[0], tokens[1]), new Point(tokens[2], tokens[3]));
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            int[] point = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            System.out.println(rec.contains(new Point(point)));
        }
    }
}
