/**
 * Created by Andrei Korotkov on 05.08.2019.
 */

package com.epam.Andrei_Korotkov.java.lesson_2.task_1;

import com.epam.Andrei_Korotkov.java.lesson_2.task_1.Exceptions.*;
import com.epam.Andrei_Korotkov.java.lesson_2.task_1.Trolleybus.Vmtz;
import com.epam.Andrei_Korotkov.java.lesson_2.task_1.bus.Nefaz;
import com.epam.Andrei_Korotkov.java.lesson_2.task_1.bus.Paz;
import com.epam.Andrei_Korotkov.java.lesson_2.task_1.tram.Skoda;

import java.util.*;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Nefaz nefaz1 = new Nefaz(200, 45, 800000, "NEFAZ-500",
                "Internal combustion engine");
        Skoda skoda1 = new Skoda(100, 30, 1500000, "Skoda-1000",
                "Electric power engine");

        Paz paz1 = new Paz(140, 33, 700000, "PAZ-10",
                "Internal combustion engine");

        Vmtz VMTZ1 = new Vmtz(110, 45, 1000000, "VMTZ-200",
                "Electric power engine");

        Transport[] ParkTransport = new Transport[4];
        ParkTransport[0] = nefaz1;
        ParkTransport[1] = skoda1;
        ParkTransport[2] = paz1;
        ParkTransport[3] = VMTZ1;
        AutoPark autoPark1 = new AutoPark(ParkTransport);

        try {
            nefaz1.setCapacity(-5);
        } catch (NegativeCapacityException | ExcessiveCapacityException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Check transport capacity by using " +
                    "System.out.println(nameOfTheTransport.Capacity) line");
        }

        try {
            skoda1.setMark(null);
        } catch (NullMarkException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Check transport Mark by using " +
                    "System.out.println(nameOfTheTransport.Mark) line");
        }

        try {
            skoda1.setPrice(5000);
        } catch (PriceException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Check transport Price by using " +
                    "System.out.println(nameOfTheTransport.Price) line");
        }

        try {
            skoda1.setEngine(null);
        } catch (NullEngineException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Check transport engine type by using " +
                    "System.out.println(nameOfTheTransport.Engine) line");
        }

        while (true) {
            int num1 = getInt();
            if (num1 == 0) break;
            switch (num1) {
                case 1:
                    autoPark1.searchByCapacity();
                    break;
                case 2:
                    autoPark1.searchByPrice();
                    break;
                case 3:
                    autoPark1.searchByMark();
                    break;
                case 4:
                    autoPark1.searchByEngine();
                    break;
                case 5:
                    autoPark1.getTotalCost();
                    break;
                case 6:
                    autoPark1.sortByCostPerKm();
                    break;
            }
        }
    }

    public static int getInt() {
        System.out.println("Enter number 1 to search by capacity, number 2 to search by price, " +
                "number 3 to search by mark, number 4 to search by engine, type number 5 " +
                "to show total vehicles' cost, type number 6 to sort by RublePerKm, " +
                "type 0 to exit");
        int num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("Error. Please enter a number");
            scanner.next();
            num = getInt();
        }
        return num;
    }
}


