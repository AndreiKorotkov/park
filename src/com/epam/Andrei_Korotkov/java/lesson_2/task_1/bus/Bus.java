package com.epam.Andrei_Korotkov.java.lesson_2.task_1.bus;

import com.epam.Andrei_Korotkov.java.lesson_2.task_1.Transport;

public abstract class Bus extends Transport {
    public static final String wayOfTravel = "road";


    public void run() {
        System.out.println("I run and consume fuel");
    }
}