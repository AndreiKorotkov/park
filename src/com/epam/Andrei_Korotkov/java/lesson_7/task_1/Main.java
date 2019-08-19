/**
 * Created by Andrei Korotkov on 05.08.2019.
 */

package com.epam.Andrei_Korotkov.java.lesson_7.task_1;

import com.epam.Andrei_Korotkov.java.lesson_7.task_1.Trolleybus.Vmtz;
import com.epam.Andrei_Korotkov.java.lesson_7.task_1.bus.Nefaz;
import com.epam.Andrei_Korotkov.java.lesson_7.task_1.bus.Paz;
import com.epam.Andrei_Korotkov.java.lesson_7.task_1.tram.Skoda;


import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Nefaz nefaz1 = new Nefaz(200, 45, 800000000, "NEFAZ-500",
                "Internal combustion engine");

        Skoda skoda1 = new Skoda(100, 80, 1500000, "Skoda-1000",
                "Electric power engine");

        Paz paz1 = new Paz(140, 33, 700000, "",
                "Internal combustion engine");

        Vmtz VMTZ1 = new Vmtz(110, 45, 1000000, "VMTZ-200",
                "Electric power engine");

        Transport[] ParkTransport = new Transport[4];
        ParkTransport[0] = nefaz1;
        ParkTransport[1] = skoda1;
        ParkTransport[2] = paz1;
        ParkTransport[3] = VMTZ1;
        AutoPark autoPark1 = new AutoPark(ParkTransport);

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
                case 7:
                    try {
                        ByteArrayOutputStream autoParkOutStream = new ByteArrayOutputStream();
                        FileOutputStream autoParkFOS = new FileOutputStream("park.txt");
                        FileChannel autoParkFileChannel = autoParkFOS.getChannel();
                        ByteBuffer autoParkByteBuffer = ByteBuffer.wrap(autoParkOutStream.toByteArray());
                        autoParkFileChannel.write(autoParkByteBuffer);
                        autoParkOutStream.close();
                        ObjectOutputStream arrayOos = new ObjectOutputStream(autoParkFOS);
                        arrayOos.writeInt(ParkTransport.length);
                        for (Transport transport : ParkTransport
                        ) {
                            arrayOos.writeObject(transport);
                        }
                        arrayOos.flush();
                        arrayOos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 8:
                    byte[] inputBufferArray = null;
                    RandomAccessFile inputFile = null;
                    try {
                        inputFile = new RandomAccessFile("D:\\java\\park\\park.txt", "rw");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    FileChannel inputFileChannel = inputFile.getChannel();
                    ByteBuffer inputBuffer = ByteBuffer.allocate(1024);
                    int bytesRead = 0;
                    try {
                        bytesRead = inputFileChannel.read(inputBuffer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    inputBuffer.flip();
                    inputBufferArray = inputBuffer.array();
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputBufferArray);
                    ObjectInputStream arrayOis = null;
                    try {
                        arrayOis = new ObjectInputStream(byteArrayInputStream);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    int ParkCount = 0;
                    try {
                        ParkCount = arrayOis.readInt();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Transport[] readPark = new Transport[ParkCount];
                    for (int i = 0; i < ParkCount; i++) {
                        try {
                            readPark[i] = (Transport) arrayOis.readObject();
                        } catch (IOException | ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Arrays.toString(readPark));
                    inputBuffer.clear();
                    try {
                        inputFile.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 9:
                    try {
                        nefaz1.checkNumbers();
                        paz1.checkNumbers();
                        skoda1.checkStrings();
                        VMTZ1.checkStrings();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        }
    }

    public static int getInt() {
        System.out.println("Enter number 1 to search by capacity, number 2 to search by price, " +
                "number 3 to search by mark, number 4 to search by engine, type number 5 " +
                "to show total vehicles' cost, type number 6 to sort by RublePerKm, type number 7 to serialize," +
                " type number 8 to deserialize, type 9 to check annotations, type 0 to exit");
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


