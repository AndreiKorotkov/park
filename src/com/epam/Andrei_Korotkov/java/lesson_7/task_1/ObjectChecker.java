package com.epam.Andrei_Korotkov.java.lesson_7.task_1;

import com.epam.Andrei_Korotkov.java.lesson_7.task_1.annotations.NumberValue;
import com.epam.Andrei_Korotkov.java.lesson_7.task_1.annotations.StringValue;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ObjectChecker {


    public void checkObjectsAnnotations (Object object) {

        Class<?> superclass;

        if (!object.getClass().getSuperclass().toString().equals("class java.lang.Object")) {

            int min;
            int max;
            try {
                Field[] fields = object.getClass().getDeclaredFields();
                for (Field f : fields) {
                    Annotation[] annotations = f.getDeclaredAnnotations();
                    for (Annotation a : annotations) {
                        if (a instanceof NumberValue) {
                            min = ((NumberValue) a).min();
                            max = ((NumberValue) a).max();
                            int value = f.getInt(object);
                            if (min > value || max < value) {
                                System.err.println(f + " is wrong");
                            } else {
                                System.out.println(f + " is correct");
                            }
                        }
                        if (a instanceof StringValue) {
                            int value = f.toString().length();
                            if (value == 0 || value > 3) {
                                System.err.println(f + " is wrong");
                            } else {
                                System.out.println(f + " is correct");
                            }
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            try {
                object = object.getClass().getSuperclass().newInstance();
                checkObjectsAnnotations(object);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }




}
