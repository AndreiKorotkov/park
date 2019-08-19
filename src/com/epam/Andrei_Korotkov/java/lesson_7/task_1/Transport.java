/**
 * Created by Andrei Korotkov on 05.08.2019.
 */

package com.epam.Andrei_Korotkov.java.lesson_7.task_1;

import com.epam.Andrei_Korotkov.java.lesson_7.task_1.annotations.NumberValue;
import com.epam.Andrei_Korotkov.java.lesson_7.task_1.annotations.StringValue;


import java.io.Serializable;
import java.lang.annotation.Annotation;

public abstract class Transport implements Comparable, Serializable {

    protected transient int RublePerKM;
    @NumberValue(min=35, max = 60)
    protected transient int Capacity;
    @NumberValue(min=100000, max=30000000)
    protected transient int Price;
    @StringValue
    protected String Mark;
    @StringValue
    protected String Engine;


    public String toString () {
        return "Mark: " +this.Mark+ ", Engine: " + this.Engine+ ", " + this.RublePerKM+ ", "
                + this.Capacity+", "+this.Price;
    }

    public int compareTo(Object obj) {
        Transport tmp = (Transport) obj;
        if (this.RublePerKM < tmp.RublePerKM) {
            // текущее меньше полученного
            return -1;
        } else if (this.RublePerKM > tmp.RublePerKM) {
            // текущее больше полученного
            return 1;
        }
        // текущее равно полученному
        return 0;
    }


    public void checkNumbers() throws Exception {
        try {
            int min;
            int max;
            Class <Transport> transportClass=Transport.class;
            Annotation[] capacityAnnotations = transportClass.getDeclaredField("Capacity").getDeclaredAnnotations();
            for (Annotation a: capacityAnnotations) {
                if (a instanceof NumberValue) {
                    max = transportClass.getDeclaredField("Capacity").getDeclaredAnnotation(NumberValue.class).max();
                    min = transportClass.getDeclaredField("Capacity").getDeclaredAnnotation(NumberValue.class).min();
                    if (max<Capacity|| min>Capacity) {
                        throw new Exception ("Wrong capacity");
                    }else {
                        System.out.println("Capacity is ok");
                    }
                }
            }
            Annotation[] priceAnnotations = transportClass.getDeclaredField("Price").getDeclaredAnnotations();
            for (Annotation a: priceAnnotations) {
                if (a instanceof NumberValue) {
                    max = transportClass.getDeclaredField("Price").getDeclaredAnnotation(NumberValue.class).max();
                    min = transportClass.getDeclaredField("Price").getDeclaredAnnotation(NumberValue.class).min();
                    if (max<Price|| min>Price) {
                        throw new Exception ("Wrong price");
                    }else {
                        System.out.println("Price is ok");
                    }
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

    }
    public void checkStrings() throws Exception {
        try {

            Class <Transport> transportClass=Transport.class;
            Annotation[] capacityAnnotations = transportClass.getDeclaredField("Engine").getDeclaredAnnotations();
            for (Annotation a: capacityAnnotations) {
                if (a instanceof StringValue) {

                    if (Engine==null||Engine.length()>3) {
                        throw new Exception ("Wrong engine type");
                    }
                    else {
                        System.out.println("Engine is ok");
                    }
                }
            }
            Annotation[] priceAnnotations = transportClass.getDeclaredField("Mark").getDeclaredAnnotations();
            for (Annotation a: priceAnnotations) {
                if (a instanceof StringValue) {

                    if (Mark==null||Mark.length()>3) {
                        throw new Exception ("Wrong mark");
                    }else {
                        System.out.println("Price is ok");
                    }
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

    }

}
