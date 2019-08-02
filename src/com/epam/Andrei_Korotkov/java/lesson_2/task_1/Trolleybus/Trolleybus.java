package com.epam.Andrei_Korotkov.java.lesson_2.task_1.Trolleybus;

import com.epam.Andrei_Korotkov.java.lesson_2.task_1.Transport;

public abstract class Trolleybus extends Transport {
    public final String wayOfTravel = "road";
    public String Engine;


    public void run() {
        System.out.println("I run on the roads and consume electricity");
    }
}
