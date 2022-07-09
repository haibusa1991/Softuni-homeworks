package lecture08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ME01ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder input = new StringBuilder(scanner.nextLine());
            String name = input.substring(input.indexOf("@")+1, input.indexOf("|"));
            String age = input.substring(input.indexOf("#")+1, input.indexOf("*"));
            people.add(String.format("%s is %s years old.", name, age));
        }
        people.forEach(System.out::println);
    }
}
