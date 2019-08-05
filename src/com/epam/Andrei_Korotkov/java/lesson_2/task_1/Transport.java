package com.epam.Andrei_Korotkov.java.lesson_2.task_1;

import java.util.*;

public abstract class Transport implements Comparable {
    protected int RublePerKM;
    protected int Capacity;
    protected int Price;
    protected String Mark;
    protected String Engine;


    public abstract void run();


    public int compareTo (Object obj) {
        Transport tmp = (Transport) obj;
        if(this.RublePerKM < tmp.RublePerKM)
        {
            /* текущее меньше полученного */
            return -1;
        }
        else if(this.RublePerKM > tmp.RublePerKM)
        {
            /* текущее больше полученного */
            return 1;
        }
        /* текущее равно полученному */
        return 0;
    }

}
