package InterfacesAndAbstraction.telephony;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split("\\s+");
        String[] sites = scanner.nextLine().split("\\s+");
        Smartphone smartphone = new Smartphone();
        callingPhoneNumbers(numbers, smartphone);
        browsingSites(sites, smartphone);
    }

    private static void browsingSites(String[] sites, Smartphone smartphone) {
        for (String site : sites) {
            System.out.println(smartphone.browse(site));
        }
    }

    private static void callingPhoneNumbers(String[] numbers, Smartphone smartphone) {
        for (String phoneNumber : numbers) {
            System.out.println(smartphone.call(phoneNumber));
        }
    }
}

