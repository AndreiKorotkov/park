package com.epam.Andrei_Korotkov.java.lesson_3.task_1.task_1.bus;

import com.epam.Andrei_Korotkov.java.lesson_3.task_1.task_1.AbleToTransport;

public class NEFAZ extends Bus implements AbleToTransport {
    public static void main(String[] args) {
    }

    public NEFAZ(int RublePerKM, int Capacity, int Price, String Mark, String Engine) {
        this.RublePerKM = RublePerKM;
        this.Capacity = Capacity;
        this.Price = Price;
        this.Mark = Mark;
        this.Engine=Engine;
   }
   public void transport () {
       System.out.println("I am " +this.Mark+ ". I travel by " +wayOfTravel+
               ", my capacity is " + (this.Capacity-30));
   }
    public void run() {
        System.out.println("I run on roads and consume fuel");
    }
}

