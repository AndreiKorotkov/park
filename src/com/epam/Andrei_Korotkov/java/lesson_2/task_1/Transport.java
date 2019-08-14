/**
 * Created by Andrei Korotkov on 05.08.2019.
 */

package com.epam.Andrei_Korotkov.java.lesson_2.task_1;

import java.io.Serializable;

public abstract class Transport implements Comparable, Serializable {

    protected transient int RublePerKM;
    protected transient int Capacity;
    protected transient int Price;
    protected String Mark;
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
}
