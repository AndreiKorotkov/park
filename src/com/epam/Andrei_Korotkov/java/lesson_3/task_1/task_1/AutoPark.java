package com.epam.Andrei_Korotkov.java.lesson_3.task_1.task_1;

import com.epam.Andrei_Korotkov.java.lesson_3.task_1.task_1.Trolleybus.VMTZ;
import com.epam.Andrei_Korotkov.java.lesson_3.task_1.task_1.bus.NEFAZ;
import com.epam.Andrei_Korotkov.java.lesson_3.task_1.task_1.bus.PAZ;
import com.epam.Andrei_Korotkov.java.lesson_3.task_1.task_1.exceptions.OverflowParkException;
import com.epam.Andrei_Korotkov.java.lesson_3.task_1.task_1.tram.Siemens;
import com.epam.Andrei_Korotkov.java.lesson_3.task_1.task_1.tram.Skoda;

import java.util.Arrays;
import java.util.Scanner;


public class AutoPark {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        int num1 = getInt();


        NEFAZ nefaz1 = new NEFAZ(200, 45, 800000,"NEFAZ-500", "Internal combustion engine");

        Skoda skoda1 = new Skoda(100, 30, 1500000, "Skoda-1000", "Electric power engine");

        PAZ paz1 = new PAZ(140, 33, 700000, "PAZ-10", "Internal combustion engine");

        VMTZ VMTZ1 = new VMTZ(110, 45, 1000000, "VMTZ-200", "Electric power engine");

        Siemens siemens1 = new Siemens(130, 35, 2000000,
                "Siemens - 120", "Electric power engine");



        AbleToTransport[] itransport = new AbleToTransport[4];

        itransport[0] = nefaz1;
        itransport[1] = skoda1;
        itransport[2] = paz1;
        itransport[3] = VMTZ1;

        for (AbleToTransport i : itransport) {
            i.transport();
        }




            Transport[] ParkTransport = new Transport[4];
            ParkTransport[0] = nefaz1;
            ParkTransport[1] = skoda1;
            ParkTransport[2] = paz1;
            ParkTransport[3] = VMTZ1;

            int p = 5;

            if (ParkTransport.length>p) {
                try {
                    throw new OverflowParkException("Слишком много автомобилей в автопарке");
                } catch
            }



        Arrays.sort(ParkTransport);

        for(int i = 0; i < ParkTransport.length; i++)
        {
            System.out.println("Cost of travel for " +ParkTransport[i].Mark+ " is "
                    +ParkTransport[i].RublePerKM + " rubles per km.");
        }

        int sum=0;
        for(int i = 0; i < ParkTransport.length; i++)
        sum+=ParkTransport[i].Price;
        {
            System.out.println("Total cost of transport is " +sum+ " rubles.");
        }



        switch (num1){
            case 1:
                System.out.println("Enter capacity:");
                int num;
                if(scanner.hasNextInt()){
                    num = scanner.nextInt();
                } else {
                    System.out.println("Error. Please enter a number");
                    scanner.next();
                    num = getInt();
                }

                int y = num;

                boolean cap = false;

                for (int i = 0; i < ParkTransport.length; i++){
                    if (y == ParkTransport[i].Capacity) {
                        System.out.println(ParkTransport[i].Mark + "'s capacity is " + ParkTransport[i].Capacity + " people");
                        cap = true;
                    }
                                        }
                if (cap==false) {
                System.out.println("Not found");
                }
                //поиск по вместимости
                break;
            case 2:
                System.out.println("Enter a price:");
                int num2;
                if(scanner.hasNextInt()){
                    num2 = scanner.nextInt();
                } else {
                    System.out.println("Error. Please enter a number");
                    scanner.next();
                    num2 = getInt();
                }

                int price = num2;

                boolean cost = false;

                for (int i = 0; i < ParkTransport.length; i++){
                    if (price == ParkTransport[i].Price) {
                        System.out.println(ParkTransport[i].Mark + "'s price is " + ParkTransport[i].Price + " rubles");
                        cost = true;
                    }

                }
                if (cost==false) {
                    System.out.println("Not found");
                }
                //поиск по цене
                break;
            case 3:
               System.out.println("Type mark of transport:");
                        Scanner sc2 = new Scanner(System.in);
                        String str = new String (sc2.nextLine());

                boolean type = false;
                for (int i = 0; i < ParkTransport.length; i++){
                    if (str.equals(ParkTransport[i].Mark)) {
                        System.out.println("There is " + ParkTransport[i].Mark + " in the park.");
                        type = true;
                    }


                }
                if (type==false) {
                    System.out.println("Not found");
                }
               //поиск по марке
                break;

            case 4:
                System.out.println("Choose engine type Electric power engine or Internal combustion engine:");
                Scanner sc3 = new Scanner(System.in);
                String transportEngine = new String (sc3.nextLine());

                boolean eng = false;
                for (int i = 0; i < ParkTransport.length; i++){
                    if (transportEngine.equals(ParkTransport[i].Engine)) {
                        System.out.println(ParkTransport[i].Mark + " has " + ParkTransport[i].Engine + ".");
                        eng = true;
                    }


                }
                if (eng==false) {
                    System.out.println("Not found");
                }
                //поиск по типу двигателя
                break;
        }


    }

    public static int getInt(){
        System.out.println("Enter number 1 to search by capacity, number 2 to search by price, " +
                "number 3 to search by mark, number 4 to search by engine, type any other number to exit");
        int num;
        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        } else {
            System.out.println("Error. Please enter a number");
            scanner.next();
            num = getInt();
        }
        return num; //ввести  номер с клавиатуры, если введено не число, выводится сообщение об ошибке
    }
    }


