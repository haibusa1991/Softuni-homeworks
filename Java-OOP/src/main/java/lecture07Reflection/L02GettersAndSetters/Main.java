package lecture07Reflection.L02GettersAndSetters;

import lecture07Reflection.Reflection;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> clazz = Reflection.class;
        Method[] methods = clazz.getDeclaredMethods();

        Method[] sortedMethods = Arrays.stream(methods)
                .filter(e -> e.getName().contains("get") || e.getName().contains("set"))
                .sorted(Main::comp)
                .toArray(Method[]::new);

        Arrays.stream(sortedMethods)
                .forEach(e -> {
                    String name = e.getName();
                    String type = "";
                    if (e.getName().contains("get")) {
                        type = "class " + e.getReturnType().toString().replace("class ", "");
                        System.out.printf("%s will return %s%n", name, type);
                    } else if (e.getName().contains("set")) {
                        type = "class " + e.getParameterTypes()[0].toString().replace("class ", "");
                        System.out.printf("%s and will set field of %s%n", name, type);
                    }
                });
    }

    private static int comp(Method m1, Method m2) {
        boolean isM1getter = m1.getName().contains("get");
        boolean isM2getter = m2.getName().contains("get");

        int res = Boolean.compare(isM2getter, isM1getter);

        if (res == 0) {
            res = m1.getName().compareTo(m2.getName());
        }

        return res;

    }


}
