/**
 * Created by Andrei Korotkov on 05.08.2019.
 */

package com.epam.Andrei_Korotkov.java.lesson_2.task_1;

public abstract class Transport implements Comparable {

    protected int RublePerKM;
    protected int Capacity;
    protected int Price;
    protected String Mark;
    protected String Engine;



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
