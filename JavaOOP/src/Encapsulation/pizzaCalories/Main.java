package Encapsulation.pizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaData = scanner.nextLine().split("\\s+");
        String pizzaName = pizzaData[1];
        int numberOfToppings = Integer.parseInt(pizzaData[2]);
        Pizza pizza;
        try {
            pizza = new Pizza(pizzaName, numberOfToppings);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String[] doughData = scanner.nextLine().split("\\s+");
        String flourType = doughData[1];
        String bakingTechnique = doughData[2];
        double weights = Double.parseDouble(doughData[3]);
        Dough dough;
        try {
            dough = new Dough(flourType, bakingTechnique, weights);
            pizza.setDough(dough);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String command = scanner.nextLine();

        while(!command.equals("END")) {
            String[] toppingData = command.split("\\s+");
            String toppingType = toppingData[1];
            double weight = Double.parseDouble(toppingData[2]);
            Topping topping;
            try {
                topping = new Topping(toppingType, weight);
                pizza.addTopping(topping);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }

            command = scanner.nextLine();
        }

        System.out.print(pizza.getName() + " - ");
        System.out.println(pizza.getOverallCalories());

    }
}
