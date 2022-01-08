package catHouse.entities.cat;

public class LonghairCat extends BaseCat {
    private static final int INITIAL_KILOGRAMS = 9;
    public LonghairCat(String name, String breed, double price) {
        super(name, breed, price);
        setKilograms(INITIAL_KILOGRAMS);
    }

    @Override
    public void eating() {
        int newKilograms = getKilograms() + 3;
        setKilograms(newKilograms);
    }
}
