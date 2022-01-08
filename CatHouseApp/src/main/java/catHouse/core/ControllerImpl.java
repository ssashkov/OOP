package catHouse.core;

import catHouse.common.ConstantMessages;
import catHouse.common.ExceptionMessages;
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
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private ToyRepository toys;
    private Map<String, House> houses;

    public ControllerImpl() {
        this.toys = new ToyRepository();
        this.houses = new LinkedHashMap<>();
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
                throw new NullPointerException(ExceptionMessages.INVALID_HOUSE_TYPE);
        }
        houses.put(house.getName(), house);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
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
                throw new IllegalArgumentException(ExceptionMessages.INVALID_TOY_TYPE);
        }
        toys.buyToy(toy);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = toys.findFirst(toyType);

        if (toy == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_TOY_FOUND, toyType));
        }
        toys.removeToy(toy);

        houses.get(houseName).buyToy(toy);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);

    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;
        if (catType.equals("ShorthairCat")) {
            cat = new ShorthairCat(catName, catBreed, price);
        } else if (catType.equals("LonghairCat")) {
            cat = new LonghairCat(catName, catBreed, price);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_CAT_TYPE);
        }

        try {
            House house = houses.get(houseName);
            house.addCat(cat);
        } catch (IllegalStateException e) {
            return e.getMessage();
        }

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
    }

    @Override
    public String feedingCat(String houseName) {
        House house = houses.get(houseName);
        house.feeding();

        return String.format(ConstantMessages.FEEDING_CAT, houses.get(houseName).getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = houses.get(houseName);
        double totalSum = house.getCats().stream().mapToDouble(Cat::getPrice).sum()
                + house.getToys().stream().mapToDouble(Toy::getPrice).sum();

        return String.format(ConstantMessages.VALUE_HOUSE, houseName, totalSum);
    }

    @Override
    public String getStatistics() {
        return houses.values().stream().map(House::getStatistics).collect(Collectors.joining(System.lineSeparator()));
    }
}
