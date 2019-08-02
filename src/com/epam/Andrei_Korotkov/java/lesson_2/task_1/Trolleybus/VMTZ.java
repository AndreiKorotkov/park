package com.epam.Andrei_Korotkov.java.lesson_2.task_1.Trolleybus;

import com.epam.Andrei_Korotkov.java.lesson_2.task_1.Transportation;

public class VMTZ extends Trolleybus implements Transportation {
    public static void main(String[] args) {
    }

    public VMTZ(int RublePerKM, int Capacity, int Price, String Mark, String Engine) {
        this.RublePerKM = RublePerKM;
        this.Capacity = Capacity;
        this.Price = Price;
        this.Mark = Mark;
        this.Engine = Engine;
    }



    public void transport () {
        System.out.println("I am " +Mark+ ". I travel by " +wayOfTravel+ ", my remaining  capacity is " + (Capacity-25));
    }
    public void run(){
        System.out.println("I run on roads and consume electricity");
    }


}
