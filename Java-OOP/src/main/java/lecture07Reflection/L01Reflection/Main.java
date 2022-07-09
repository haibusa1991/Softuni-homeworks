package lecture07Reflection.L01Reflection;



import lecture07Reflection.Reflection;

import java.lang.reflect.Constructor;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> reflection = Reflection.class;
        System.out.println(reflection);
        System.out.println(reflection.getSuperclass());
        Class[] interfaces = reflection.getInterfaces();

        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

        try {
            Constructor<Reflection> ctor = reflection.getDeclaredConstructor();
            Reflection ref = ctor.newInstance();
            System.out.println(ref);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
