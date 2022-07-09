package lecture07Reflection.E03_E04_E05BarracksWars.core.factories;

import lecture07Reflection.E03_E04_E05BarracksWars.interfaces.Unit;
import lecture07Reflection.E03_E04_E05BarracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "lecture07Reflection.E03_E04_E05BarracksWars.models.units.";

    @Override
    public Unit createUnit(String unitType) {
        try {
            Class<?> unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
            Constructor<?> ctor = unitClass.getDeclaredConstructor();
            return (Unit) ctor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

