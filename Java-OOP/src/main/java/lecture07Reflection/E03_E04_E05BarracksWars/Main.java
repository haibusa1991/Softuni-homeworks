package lecture07Reflection.E03_E04_E05BarracksWars;

import lecture07Reflection.E03_E04_E05BarracksWars.interfaces.Repository;
import lecture07Reflection.E03_E04_E05BarracksWars.interfaces.Runnable;
import lecture07Reflection.E03_E04_E05BarracksWars.interfaces.UnitFactory;
import lecture07Reflection.E03_E04_E05BarracksWars.core.Engine;
import lecture07Reflection.E03_E04_E05BarracksWars.core.factories.UnitFactoryImpl;
import lecture07Reflection.E03_E04_E05BarracksWars.data.UnitRepository;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
