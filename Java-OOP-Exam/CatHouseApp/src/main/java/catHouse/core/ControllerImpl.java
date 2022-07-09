package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;

import java.util.ArrayList;
import java.util.Collection;

import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private ToyRepository toys;
    private Collection<House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;
        switch (type) {
            case "ShortHouse":
                house = new ShortHouse(name);
                break;
            case "LongHouse":
                house = new LongHouse(name);
                break;
            default:
                throw new NullPointerException(INVALID_HOUSE_TYPE);
        }

        houses.add(house);

        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;
        switch (type) {
            case "Ball":
                toy = new Ball();
                break;
            case "Mouse":
                toy = new Mouse();
                break;
            default:
                throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }
        this.toys.buyToy(toy);

        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = this.toys.findFirst(toyType);

        if (toy == null) {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }

        House house = getHouseByName(houseName);
        house.buyToy(toy);
        toys.removeToy(toy);

        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;
        switch (catType) {
            case "ShorthairCat":
                cat = new ShorthairCat(catName, catBreed, price);
                break;
            case "LonghairCat":
                cat = new LonghairCat(catName, catBreed, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }

        House house = getHouseByName(houseName);
        boolean isShortHouse = house.getClass().getSimpleName().equals("ShortHouse");
        boolean isShorthairCat = catType.equals("ShorthairCat");

        if ((isShorthairCat && !isShortHouse)
                || (!isShorthairCat && isShortHouse)) {
            return UNSUITABLE_HOUSE;
        }

        house.addCat(cat);
        return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
    }

    @Override
    public String feedingCat(String houseName) {
        House house = getHouseByName(houseName);

        house.feeding();

        return String.format(FEEDING_CAT, house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        double toysSum = houses.stream()
                .filter(e -> e.getName().equals(houseName))
                .map(House::getToys)
                .map(e -> e.stream()
                        .mapToDouble(Toy::getPrice)
                        .sum())
                .findFirst()
                .orElse(0.0);

        double catsSum = houses.stream()
                .filter(e -> e.getName().equals(houseName))
                .map(House::getCats)
                .map(e -> e.stream()
                        .mapToDouble(Cat::getPrice)
                        .sum())
                .findFirst()
                .orElse(0.0);

        return String.format(VALUE_HOUSE, houseName, toysSum + catsSum);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (House house : houses) {
            sb.append(house.getStatistics())
                    .append(System.lineSeparator());
        }

        return sb.toString();
    }

    private House getHouseByName(String name) {
        return houses.stream()
                .filter(e->e.getName().equals(name))
                .findFirst()
                .get();

//        for (House currentHouse : houses) {
//            if (currentHouse.getName().equals(name)) {
//                return currentHouse;
//            }
//        }
//        throw new NullPointerException(String.format("No house by name %s", name));
    }
}
