package com.epam.Andrei_Korotkov.java.lesson_2.task_1;

import com.epam.Andrei_Korotkov.java.lesson_2.task_1.Trolleybus.Vmtz;
import com.epam.Andrei_Korotkov.java.lesson_2.task_1.bus.Nefaz;
import com.epam.Andrei_Korotkov.java.lesson_2.task_1.bus.Paz;
import com.epam.Andrei_Korotkov.java.lesson_2.task_1.tram.Skoda;

import java.util.*;

/**
 * Created by Andrei Korotkov on 05.08.2019.
 */

public class Main {

    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        while (true) {

            Transport nefaz1 = new Nefaz(200, 45, 800000, "NEFAZ-500",
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

            int num1 = getInt();


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
                "type any other number to exit");
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


