/**
 * Created by Andrei Korotkov on 05.08.2019.
 */

package com.epam.Andrei_Korotkov.java.lesson_7.task_1.Trolleybus;

import com.epam.Andrei_Korotkov.java.lesson_7.task_1.Transportation;

public class Vmtz extends Trolleybus implements Transportation {

    public Vmtz(int RublePerKM, int Capacity, int Price, String Mark, String Engine) {
        this.RublePerKM = RublePerKM;
        this.Capacity = Capacity;
        this.Price = Price;
        this.Mark = Mark;
        this.Engine = Engine;
    }

    public void transport () {
        System.out.println("I am " +Mark+ ". I travel by " +wayOfTravel+ ", my remaining  capacity is " + (Capacity-25));
    }
}
