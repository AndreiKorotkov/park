/**
 * Created by Andrei Korotkov on 05.08.2019.
 */

package com.epam.Andrei_Korotkov.java.lesson_2.task_1;

import com.epam.Andrei_Korotkov.java.lesson_2.task_1.Exceptions.*;

public abstract class Transport implements Comparable {

    protected int RublePerKM;
    protected int Capacity;
    protected int Price;
    protected String Mark;
    protected String Engine;


    public void setCapacity(int Capacity) throws NegativeCapacityException, ExcessiveCapacityException {
        if (Capacity < 0)
            throw new NegativeCapacityException("You have entered negative capacity");
        if (Capacity > 55)
            throw new ExcessiveCapacityException("Capacity should not exceed 55 people");

    }

    public void setPrice(int Price) throws PriceException {
        if (Price < 100000)
            throw new PriceException("Incorrect price");
    }

    public void setMark(String Mark) throws NullMarkException {
        if (Mark == null)
            throw new NullMarkException("Input correct Mark");
    }

    public void setEngine(String Engine) throws NullEngineException {
        if (Engine == null)
            throw new NullEngineException("Incorrect engine type");
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
