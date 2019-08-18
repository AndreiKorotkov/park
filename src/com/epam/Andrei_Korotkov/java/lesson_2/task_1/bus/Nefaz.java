/**
 * Created by Andrei Korotkov on 05.08.2019.
 */

package com.epam.Andrei_Korotkov.java.lesson_2.task_1.bus;

import com.epam.Andrei_Korotkov.java.lesson_2.task_1.Transportation;
import com.epam.Andrei_Korotkov.java.lesson_2.task_1.annotations.EngineAnnotation;

public class Nefaz extends Bus implements Transportation {

    public Nefaz(int RublePerKM, int Capacity, int Price, String Mark, String Engine) {
        this.RublePerKM = RublePerKM;
        this.Capacity = Capacity;
        this.Price = Price;
        this.Mark = Mark;
        this.Engine=Engine;
   }
    public Nefaz () {

    }

    @EngineAnnotation(Engine = "Internal combustion engine")
    protected String Engine;

//    public void checkEngine () {
//        try {
//       String EngineValue;
//       Class <Nefaz> nefazClass=Nefaz.class;
//
//            if (nefazClass.getField("Engine").isAnnotationPresent(EngineAnnotation)); {
//
//            }
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
//    }


    public void transport () {
       System.out.println("I am " +this.Mark+ ". I travel by " +wayOfTravel+
               ", my capacity is " + (this.Capacity-30));
   }
}

