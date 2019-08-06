package com.epam.Andrei_Korotkov.java.lesson_2.task_1.bus;

import com.epam.Andrei_Korotkov.java.lesson_2.task_1.Transportation;

/**
 * Created by Andrei Korotkov on 05.08.2019.
 */

public class Nefaz extends Bus implements Transportation {

    public Nefaz(int RublePerKM, int Capacity, int Price, String Mark, String Engine) {
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

}

