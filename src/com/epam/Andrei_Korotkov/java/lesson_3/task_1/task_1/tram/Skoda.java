package com.epam.Andrei_Korotkov.java.lesson_3.task_1.task_1.tram;

import com.epam.Andrei_Korotkov.java.lesson_3.task_1.task_1.AbleToTransport;

public class Skoda extends Tram implements AbleToTransport {
    public static void main(String[] args) {
    }

    public Skoda(int RublePerKM, int Capacity, int Price, String Mark, String Engine) {
        this.RublePerKM = RublePerKM;
        this.Capacity = Capacity;
        this.Price = Price;
        this.Mark = Mark;
        this.Engine=Engine;
    }
    public void transport () {
        System.out.println("I am " + this.Mark+ ". I travel by " +wayOfTravel+
                ", my remaining capacity is " + (this.Capacity-10));
    }
    public void run(){
        System.out.println("I run on rails and consume electricity");
}
}
