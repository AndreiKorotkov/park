/**
 * Created by Andrei Korotkov on 05.08.2019.
 */

package com.epam.Andrei_Korotkov.java.lesson_2.task_1;

import java.util.Arrays;
import java.util.Scanner;

import static com.epam.Andrei_Korotkov.java.lesson_2.task_1.Main.getInt;
import static com.epam.Andrei_Korotkov.java.lesson_2.task_1.Main.scanner;

public class AutoPark {
    Transport[] transport;

    public AutoPark(Transport[] transport) {
        this.transport = transport;
    }

    public void searchByCapacity() {

        System.out.println("Enter minimal capacity:");
        int num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("Error. Please enter a number");
            scanner.next();
            num = getInt();
        }

        System.out.println("Enter maximum capacity:");
        int num2;
        if (scanner.hasNextInt()) {
            num2 = scanner.nextInt();
        } else {
            System.out.println("Error. Please enter a number");
            scanner.next();
            num2 = getInt();
        }
        int soughtCapacityMIn = num;
        int soughtCapacityMax = num2;
        boolean Cap = false;

        for (int i = 0; i < transport.length; i++) {
            if (soughtCapacityMIn <= transport[i].Capacity &&
                    soughtCapacityMax >= transport[i].Capacity) {
                System.out.println(transport[i].Mark + "'s capacity is " +
                        transport[i].Capacity + " people");
                Cap = true;
            }
        }
        if (Cap == false) {
            System.out.println("Not found");
        }
    }

    public void searchByPrice() {
        System.out.println("Enter minimal price:");
        int num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("Error. Please enter a number");
            scanner.next();
            num = getInt();
        }

        System.out.println("Enter maximum price:");
        int num2;
        if (scanner.hasNextInt()) {
            num2 = scanner.nextInt();
        } else {
            System.out.println("Error. Please enter a number");
            scanner.next();
            num2 = getInt();
        }
        int SoughtPriceMin = num;
        int SoughtPriceMax = num2;
        boolean Cost = false;

        for (int i = 0; i < transport.length; i++) {
            if (SoughtPriceMax >= transport[i].Price && SoughtPriceMin <= transport[i].Price) {
                System.out.println(transport[i].Mark + "'s price is "
                        + transport[i].Price + " rubles");
                Cost = true;
            }
        }
        if (Cost == false) {
            System.out.println("Not found");
        }
    }

    public void searchByMark() {
        System.out.println("Type mark of transport:");
        Scanner MarkOfTransportScanner = new Scanner(System.in);
        String str = MarkOfTransportScanner.nextLine();
        boolean Type = false;
        for (int i = 0; i < transport.length; i++) {
            if (str.equals(transport[i].Mark)) {
                System.out.println("There is " + transport[i].Mark + " in the park.");
                Type = true;
            }
        }
        if (Type == false) {
            System.out.println("Not found");
        }
    }

    public void searchByEngine() {
        System.out.println("Choose engine type Electric power engine or " +
                "Internal combustion engine:");
        Scanner EngineTypeScanner = new Scanner(System.in);
        String transportEngine = EngineTypeScanner.nextLine();
        boolean Eng = false;
        for (int i = 0; i < transport.length; i++) {
            if (transportEngine.equals(transport[i].Engine)) {
                System.out.println(transport[i].Mark + " has " +
                        transport[i].Engine + ".");
                Eng = true;
            }
        }
        if (Eng == false) {
            System.out.println("Not found");
        }
    }

    public void getTotalCost() {
        int sum = 0;
        for (int i = 0; i < transport.length; i++)
            sum += transport[i].Price;
        {
            System.out.println("Total cost of vehicles is " + sum + " rubles.");
        }
    }

    public void sortByCostPerKm() {
        Arrays.sort(transport);

        for (int i = 0; i < transport.length; i++) {
            System.out.println("Cost of travel for " + transport[i].Mark + " is "
                    + transport[i].RublePerKM + " rubles per km.");
        }
    }
}