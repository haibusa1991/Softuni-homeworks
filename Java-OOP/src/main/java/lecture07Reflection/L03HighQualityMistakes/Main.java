package lecture07Reflection.L03HighQualityMistakes;

import lecture07Reflection.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> clazz = Reflection.class;
        Field[] fields = clazz.getDeclaredFields();

        Arrays.stream(fields)
                .filter(e -> !Modifier.toString(e.getModifiers()).contains("private"))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(e -> System.out.printf("%s must be private!%n", e.getName()));

        Method[] methods = Arrays.stream(clazz.getDeclaredMethods())
                .filter(e -> e.getName().startsWith("set") || e.getName().startsWith("get"))
                .toArray(Method[]::new);

        Arrays.stream(methods)
                .filter(e -> e.getName().startsWith("get"))
                .filter(e -> !isPublic(e))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(e -> System.out.printf("%s have to be public!%n", e.getName()));

        Arrays.stream(methods)
                .filter(e -> e.getName().startsWith("set"))
                .filter(Main::isPublic)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(e -> System.out.printf("%s have to be private!%n", e.getName()));


    }

    private static boolean isPublic(Method m) {
        return Modifier.toString(m.getModifiers()).contains("public");
    }
}
