package lecture07Reflection.E02BlackBoxInteger;

import lecture07Reflection.BlackBoxInt;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<BlackBoxInt> clazz = BlackBoxInt.class;

        Field innerValue = clazz.getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        Constructor<BlackBoxInt> ctor = clazz.getDeclaredConstructor();
        ctor.setAccessible(true);

        BlackBoxInt bbi = ctor.newInstance();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split("_");
            String methodName = tokens[0];
            int value = Integer.parseInt(tokens[1]);

            Method method = bbi.getClass().getDeclaredMethod(methodName, int.class);
            method.setAccessible(true);
            method.invoke(bbi,value);

            System.out.println(innerValue.get(bbi));
            input=scanner.nextLine();
        }
    }
}
