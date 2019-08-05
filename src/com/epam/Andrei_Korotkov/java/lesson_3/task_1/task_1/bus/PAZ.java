package com.epam.Andrei_Korotkov.java.lesson_3.task_1.task_1.bus;

import com.epam.Andrei_Korotkov.java.lesson_3.task_1.task_1.AbleToTransport;

public class PAZ extends Bus implements AbleToTransport {
    public static void main(String[] args) {
    }

    public PAZ(int RublePerKM, int Capacity, int Price, String Mark, String Engine) {
        this.RublePerKM = RublePerKM;
        this.Capacity = Capacity;
        this.Price = Price;
        this.Mark = Mark;
        this.Engine=Engine;
    }
    public void transport () {
        System.out.println("I am " +Mark+ ". I travel by " +wayOfTravel+
                ", my capacity is " + (Capacity-25));
    }
    public void run() {
        System.out.println("I run on roads and consume fuel" + Engine);
    }
}
