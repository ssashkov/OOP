package InterfacesAndAbstraction.birthdayCelebration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> thingsWithBirthdate = new ArrayList<>();
        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String[] data = command.split("\\s+");
            String type = data[0];

            switch (type) {
                case "Citizen":
                    String name = data[1];
                    int age = Integer.parseInt(data[2]);
                    String id = data[3];
                    String birthDate = data[4];
                    Citizen citizen = new Citizen(name, age, id, birthDate);
                    thingsWithBirthdate.add(citizen);
                    break;
                case "Robot":
                    String model = data[1];
                    String robotId = data[2];
                    Robot robot = new Robot(model, robotId);
                    break;
                case "Pet":
                    String petName = data[1];
                    String petBirthDay = data[2];
                    Pet pet = new Pet(petName, petBirthDay);
                    thingsWithBirthdate.add(pet);
                    break;
            }
            command = scanner.nextLine();
        }

        String year = scanner.nextLine();

        boolean isFound = false;
        for (Birthable thingWithABirthday : thingsWithBirthdate) {
            if (thingWithABirthday.getBirthDate().endsWith(year)) {
                isFound = true;
                System.out.println(thingWithABirthday.getBirthDate());
            }
        }

        if (!isFound) {
            System.out.println("<no output>");
        }
    }
}
