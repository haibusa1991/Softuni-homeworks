package lecture07Reflection.E01HarvestingFields;

import lecture07Reflection.RichSoilLand;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Class<RichSoilLand> clazz = RichSoilLand.class;
        Field[] fields = clazz.getDeclaredFields();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("HARVEST")) {

            if (input.equals("all")) {
                input = "";
            }
            String modifier = input;

            Arrays.stream(fields)
                    .filter(e -> Modifier.toString(e.getModifiers()).contains(modifier))
                    .forEach(e -> System.out.println(Modifier.toString(e.getModifiers()) + " " + e.getType().getSimpleName() + " " + e.getName()));

            input = scanner.nextLine();
        }
    }
}
