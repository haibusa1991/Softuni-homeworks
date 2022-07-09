package lecture07Reflection.E03_E04_E05BarracksWars.core;
import lecture07Reflection.E03_E04_E05BarracksWars.core.commands.Command;
import lecture07Reflection.E03_E04_E05BarracksWars.core.commands.Inject;
import lecture07Reflection.E03_E04_E05BarracksWars.data.UnitRepository;
import lecture07Reflection.E03_E04_E05BarracksWars.interfaces.Repository;
import lecture07Reflection.E03_E04_E05BarracksWars.interfaces.Runnable;
import lecture07Reflection.E03_E04_E05BarracksWars.interfaces.UnitFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

public class Engine implements Runnable {

    private Repository repository;
    private UnitFactory unitFactory;
    private final String COMMAND_PATH = "lecture07Reflection.E03_E04_E05BarracksWars.core.commands.";

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpretCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String interpretCommand(String[] data, String commandName) {

        try {
            Class<?> clazz = Class.forName(COMMAND_PATH + capitalize(commandName));

            Constructor<?> ctor = clazz.getDeclaredConstructor(String[].class);
            ctor.setAccessible(true);

            Command command = (Command) ctor.newInstance((Object) data);


            Field[] fields = Arrays.stream(clazz.getDeclaredFields())
                    .filter(e -> e.isAnnotationPresent(Inject.class))
                    .toArray(Field[]::new);

            for (Field field : fields) {
                field.setAccessible(true);

                if (field.getType() == Repository.class){
                    field.set(command, this.repository);
                } else if (field.getType() == UnitFactory.class){
                    field.set(command, this.unitFactory);
                }
            }

            return command.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Invalid command!");
        }
    }

    private String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
    }
}
